package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<ClienteModel, Long> {
    ClienteModel findByEmail(String email);
    void findById(long id);

}
