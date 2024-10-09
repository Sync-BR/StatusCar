package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.model.VeiculoModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired(required = true)
    private ClienteRepository clienteRepository;
    @GetMapping("/allClientes")
    public ResponseEntity<List<ClienteModel>> returnClientes(){
        List<ClienteModel> clientes = clienteRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getCpfById(String cpf){
        ClienteModel cliente = clienteRepository.findByCpf(cpf);
        VeiculoModel veiculo = veiculoRepository.findByclienteID(cliente.getId());
        return new ResponseEntity<>(veiculo.getId(), HttpStatus.OK);
    }


    @PostMapping("/user/add")
    public ResponseEntity<HttpStatus> cadastrarCliente(@RequestBody ClienteModel cadCliente){
        if(cadCliente.getCpf().isEmpty()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            clienteRepository.save(cadCliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }



    @DeleteMapping("/user/delete{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/user/update{id}")
    public ResponseEntity<HttpStatus> updateCliente(@PathVariable Long id,@RequestBody ClienteModel cliente) {
        cliente.setId(Integer.parseInt(id.toString()));
        clienteRepository.save(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
