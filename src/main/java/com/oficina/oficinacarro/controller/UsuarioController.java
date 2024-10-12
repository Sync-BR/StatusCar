package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.enums.UsersEnums;
import com.oficina.oficinacarro.model.AutenticacaoModel;
import com.oficina.oficinacarro.model.UsuarioModel;
import com.oficina.oficinacarro.repository.LoginRepository;
import com.oficina.oficinacarro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {
    @Autowired(required = true)
    private UsuarioRepository usuarioRepository;
    @Autowired(required = true)
    private LoginRepository loginRepository;

    @PostMapping("/adicionar")
    private ResponseEntity<HttpStatus> addCliente(@RequestBody UsuarioModel user) {
        usuarioRepository.save(user);
        AutenticacaoModel autenticacaoModel = new AutenticacaoModel();
        autenticacaoModel.setId(user.getId());
        autenticacaoModel.setCpf(user.getCpf());
        autenticacaoModel.setSenha(user.getSenha());
        loginRepository.save(autenticacaoModel);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

}
