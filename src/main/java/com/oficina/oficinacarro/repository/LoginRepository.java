package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.AutenticacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<AutenticacaoModel, Long> {
    AutenticacaoModel findByUsuario(String login);
}
