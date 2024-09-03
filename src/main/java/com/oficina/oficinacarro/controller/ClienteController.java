package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired()
    private ClienteRepository clienteRepository;

    @PostMapping("/user/add")
    public ResponseEntity<HttpStatus> addCliente(ClienteModel cliente){
        clienteRepository.save(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
