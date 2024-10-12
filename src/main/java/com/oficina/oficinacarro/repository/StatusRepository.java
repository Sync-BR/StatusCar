package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<StatusModel, Long> {
    StatusModel findById(int id);
    List<StatusModel> findAllById(int id);

}
