package com.oficina.oficinacarro.service;

import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Buscar o status do veículo chamando a stored procedure
    public List<Object[]> getStatusVeiculo(Long id) {
        return veiculoRepository.getStatusVeiculo(id);
    }

    // Alterar o status do veículo chamando a stored procedure
    @Transactional
    public void updateStatusVeiculo(Long id, Long novoStatus) {
        veiculoRepository.updateStatusVeiculo(id, novoStatus);
    }
}
