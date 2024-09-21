package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
    List<VeiculoModel> findByclienteID(int clienteID);
    VeiculoModel findByplaca(String placa);
    void deleteByplaca(String placa);
}
