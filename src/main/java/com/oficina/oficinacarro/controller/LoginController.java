package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.AutenticacaoModel;
import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import com.oficina.oficinacarro.repository.LoginRepository;
import com.oficina.oficinacarro.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class LoginController {
    @Autowired()
    private LoginRepository loginRepository;
    @Autowired()
    private ClienteRepository clienteRepository;
    @Autowired
    private EmailService emailService;
    @CrossOrigin(origins = "http://186.247.89.58:8080")
    @PostMapping("/login{cpf}password{password}")
    public ResponseEntity<HttpStatus> login(@PathVariable String cpf, @PathVariable String password) {
        System.out.println("Login: " +cpf+ " Password: "+password);
        AutenticacaoModel user = loginRepository.findByCpf(cpf);
        if (user.getCpf().equals(cpf) && user.getSenha().equals(password)) {
            int rank = user.getRank().ordinal();
            switch (rank) {
                case 0:
                    System.out.println("cliente");
                    return new ResponseEntity<>(HttpStatus.OK);
                case 1:
                    System.out.println("Consultores");
                    return new ResponseEntity<>(HttpStatus.OK);
                case 2:
                    System.out.println("Administradores");
                    return new ResponseEntity<>(HttpStatus.OK);
                case 3:
                    System.out.println("Desenvolvedor");
                    return new ResponseEntity<>(HttpStatus.OK);
            }


        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/usersLogin{email}")

    public ResponseEntity<HttpStatus> recuperarSenha(@PathVariable String email) {
        System.out.println("Passei");
        ClienteModel clienteRecover = clienteRepository.findByEmail(email);
        if (clienteRecover != null) {
            String subject = "Recuperação de senha";
            String text = "Olá, " + clienteRecover.getNome() +
                    ". Sua senha é: " + clienteRecover.getSenha();
            emailService.sendEmail(clienteRecover.getEmail(), subject, text);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
