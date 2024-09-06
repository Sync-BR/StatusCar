package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.VeiculoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {


    @PostMapping("/addveiculo")
    public ResponseEntity<HttpStatus> addVeiculo(@RequestBody VeiculoModel veiculo) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
