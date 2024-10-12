package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.dto.VeiculoStatusDTO;
import com.oficina.oficinacarro.enums.StateCar;
import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.model.VeiculoModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import com.oficina.oficinacarro.repository.StatusRepository;
import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired(required = true)
    private ClienteRepository clienteRepository;
    @Autowired(required = true)
    private VeiculoRepository veiculoRepository;
    @Autowired(required = true)
    private StatusRepository statusRepository;

    @PutMapping("/update/{placa}")
    public ResponseEntity<VeiculoModel> updateVeiculo(@PathVariable String placa, @RequestBody VeiculoModel veiculoModel) {
        VeiculoModel veiculos = veiculoRepository.findByplaca(placa);
        if (veiculos != null) {
            veiculoModel.setId(veiculos.getId());
            veiculoModel.setClienteID(veiculos.getClienteID());
            veiculoRepository.save(veiculoModel);
        }
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }


    @PostMapping("/addveiculo/{status}")
    public ResponseEntity<HttpStatus> addVeiculo(@RequestBody VeiculoModel veiculo, @PathVariable String status) {
        System.out.println(veiculo.getClienteID());
        System.out.println(status);
        VeiculoModel veiculos = veiculoRepository.save(veiculo);
        StatusModel statusModel = new StatusModel();
        Date data = new Date();
        Date dataFim = new Date();
        statusModel.setId(veiculos.getId());
        statusModel.setStatus(status);
        statusModel.setDataInicio(data);
        statusModel.setDataFim(dataFim);
        statusRepository.save(statusModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/consultar/veiculos/cpf/{cpf}")
    public ResponseEntity<List<VeiculoModel>> getVeiculos(@PathVariable String cpf) {
        ClienteModel clienteCoppy = clienteRepository.findByCpf(cpf);
        List<VeiculoModel> veiculos = veiculoRepository.findByClienteID(clienteCoppy.getId());
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/consultar/veiculos/{cpf}")
    public ResponseEntity<List<VeiculoStatusDTO>> getVeiculo(@PathVariable String cpf) {
        ClienteModel clienteCoppy = clienteRepository.findByCpf(cpf);
        List<VeiculoModel> veiculos = veiculoRepository.findByClienteID(clienteCoppy.getId());
        List<VeiculoStatusDTO> veiculoStatusList = new ArrayList<>();
        for(VeiculoModel veiculo : veiculos){
            StatusModel statusModel = statusRepository.findById(veiculo.getId());
            VeiculoStatusDTO veiculoStatusDTO = new VeiculoStatusDTO(veiculo, statusModel);
            veiculoStatusList.add(veiculoStatusDTO);
        }
        return new ResponseEntity<>(veiculoStatusList, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{placa}")
    @Transactional

    public ResponseEntity<HttpStatus> deleteVeiculo(@PathVariable String placa) {
        veiculoRepository.deleteByplaca(placa);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
