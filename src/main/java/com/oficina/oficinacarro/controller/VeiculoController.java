package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.enums.StateCar;
import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.model.VeiculoModel;
import com.oficina.oficinacarro.repository.StatusRepository;
import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired(required = true)
    private VeiculoRepository veiculoRepository;
//    @Autowired(required = true)
//    private StatusRepository statusRepository;

    @PostMapping("/update/{placa}")
    public ResponseEntity<VeiculoModel> updateVeiculo(@PathVariable String placa, @RequestBody VeiculoModel veiculoModel) {
        VeiculoModel veiculos = veiculoRepository.findByplaca(placa);
        if (veiculos != null) {
            veiculoModel.setId(veiculos.getId());
            veiculoModel.setClienteID(veiculos.getClienteID());
            veiculoRepository.save(veiculoModel);
        }
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    //    private void addStatusDefault(StatusModel statusModel) {
//        statusRepository.save(statusModel);
//    }
    @PostMapping("/addveiculo")
    public ResponseEntity<HttpStatus> addVeiculo(@RequestBody VeiculoModel veiculo) {
        System.out.println(veiculo.getClienteID());
        VeiculoModel veiculos = veiculoRepository.save(veiculo);
        StatusModel statusModel = new StatusModel(veiculos.getId(), "Em analise");
//        addStatusDefault(statusModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/consultar/veiculos/{clienteId}")
    public ResponseEntity<List<VeiculoModel>> getVeiculo(@PathVariable int clienteId) {
        List<VeiculoModel> veiculos = veiculoRepository.findByclienteID(clienteId);

        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{placa}")
    @Transactional

    public ResponseEntity<HttpStatus> deleteVeiculo(@PathVariable String placa) {
        veiculoRepository.deleteByplaca(placa);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
