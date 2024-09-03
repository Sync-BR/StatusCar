package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired(required = true)
    private ClienteRepository clienteRepository;

    @PostMapping("/user/add")
    public ResponseEntity<HttpStatus> addCliente(@RequestBody ClienteModel cliente){
        clienteRepository.save(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
