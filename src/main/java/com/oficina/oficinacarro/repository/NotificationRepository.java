package com.oficina.oficinacarro.repository;

import com.oficina.oficinacarro.model.NotificationModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM NotificationModel n WHERE n.id_Veiculo = :idVeiculo")
    int deleteByIdVeiculo(@Param("idVeiculo") int idVeiculo);
    @Query("SELECT n FROM NotificationModel n WHERE n.id_Veiculo = :idVeiculo")
    List<NotificationModel> findById_Veiculo(@Param("idVeiculo") int idVeiculo);

    @Query("SELECT n FROM NotificationModel n WHERE n.id_Veiculo = :idVeiculos")
    NotificationModel findByIdVeiculo(int idVeiculos);





}
