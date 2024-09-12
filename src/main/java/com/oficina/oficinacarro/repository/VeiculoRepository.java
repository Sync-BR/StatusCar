package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
}
