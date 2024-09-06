package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.AutenticacaoModel;
import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import com.oficina.oficinacarro.repository.LoginRepository;
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

        @PostMapping("/login{username}password{password}")
        public ResponseEntity<HttpStatus> login(@PathVariable String username, @PathVariable String password) {
            AutenticacaoModel user = loginRepository.findByUsuario(username);
            System.out.println(user);
            if (user != null && user.getSenha().equals(password)) {
                int rank = user.getRank().ordinal();
                System.out.println(rank);
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
        public ResponseEntity<ClienteModel> recuperarSenha(@PathVariable String email) {
            ClienteModel clienteRecover =  clienteRepository.findByEmail(email);
            System.out.println(clienteRecover);
            return new ResponseEntity<>(clienteRecover,HttpStatus.OK);
        }
    }
