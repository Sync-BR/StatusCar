package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusModel, Long> {
}
