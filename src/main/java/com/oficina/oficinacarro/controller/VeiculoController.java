package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.model.VeiculoModel;
import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired(required = true)
    private VeiculoRepository veiculoRepository;

    @PostMapping("/addveiculo")
    public ResponseEntity<HttpStatus> addVeiculo( @RequestBody VeiculoModel veiculo) {
        veiculoRepository.save(veiculo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/consultar/veiculos")
    public ResponseEntity<List<VeiculoModel>> getVeiculo(){
        List<VeiculoModel> veiculos = veiculoRepository.findAll();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

}
