package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.AutenticacaoModel;
import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.model.UsuarioModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import com.oficina.oficinacarro.repository.LoginRepository;
import com.oficina.oficinacarro.repository.UsuarioRepository;
import com.oficina.oficinacarro.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public  int getType(long id){
        UsuarioModel user = usuarioRepository.getReferenceById(id);
        return user.getTipo_user().ordinal();
    }


    @PostMapping("/login/{cpf}/{password}")
    public ResponseEntity<String> login(@PathVariable String cpf, @PathVariable String password) {
        AutenticacaoModel autenticacao = new AutenticacaoModel();
        autenticacao.setCpf(cpf);
        autenticacao.setSenha(password);
        AutenticacaoModel user = loginRepository.findByCpf(autenticacao.getCpf());
        if (user != null) {
            if(autenticacao.getCpf().equals(user.getCpf()) && autenticacao.getSenha().equals(user.getSenha())) {
                long tipo = getType(user.getId());
                String json = "{" +
                        "\"tipo_user\": " + tipo + // Se tipo for numérico
                        "}";
                return new ResponseEntity<>(json +tipo,HttpStatus.OK);
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
