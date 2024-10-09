package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.VeiculoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
    List<VeiculoModel> findByClienteID(int clienteID);
    VeiculoModel findByclienteID(int clienteID);
    @Query("SELECT v FROM VeiculoModel v WHERE v.placa = :placa")
    VeiculoModel findByplaca(String placa);
    void deleteByplaca(String placa);


}
