package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {

    List<VeiculoModel> findByclienteID(int clienteID);
    VeiculoModel findByplaca(String placa);
    void deleteByplaca(String placa);




    // Chama a Stored Procedure para buscar o status do veículo
    @Query(value = "CALL getStatusVeiculo(:id)", nativeQuery = true)
    List<Object[]> getStatusVeiculo(Long id);

    // Chama a Stored Procedure para alterar o status do veículo
    @Modifying
    @Transactional
    @Query(value = "CALL updateStatusVeiculo(:id, :novoStatus)", nativeQuery = true)
    void updateStatusVeiculo(Long id, Long novoStatus);


}
