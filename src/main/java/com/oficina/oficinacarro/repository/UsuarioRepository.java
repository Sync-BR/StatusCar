package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
