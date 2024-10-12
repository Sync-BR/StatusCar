package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.NotificationModel;
import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.repository.NotificationRepository;
import com.oficina.oficinacarro.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void addStatusDefault(StatusModel statusModel) {
        statusRepository.save(statusModel);
    }

    private void getByIdNotification(int id) {
        NotificationModel notificaoinfor = notificationRepository.findByIdVeiculo(id);
        if (notificaoinfor != null && notificaoinfor.getId_Notification() != 0) {
            // Se existir e o ID da notificação for válido, deleta
            notificationRepository.deleteById((long) notificaoinfor.getId_Notification());
        } else {
            // Opcional: pode-se logar ou tratar o caso onde não existe notificação
            System.out.println("Nenhuma notificação encontrada para o veículo com ID: " + id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusModel> getStatusById(@PathVariable int id) {
        System.out.println(id);
        StatusModel status = statusRepository.findById(id);
        System.out.println(status);
        if (status.getId() != 0) {
            getByIdNotification(status.getId());
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.notFound().build();
        // NotificationModel notificaoinfor = notificationRepository.findByIdVeiculo(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StatusModel> getStatusByIds(@PathVariable int id) {
        System.out.println(id);
        StatusModel status = statusRepository.findById(id);
        if (status.getId() != 0) {
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.notFound().build();
        // NotificationModel notificaoinfor = notificationRepository.findByIdVeiculo(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody StatusModel updatedStatus) {
        System.out.println(updatedStatus);
        StatusModel status = statusRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado para o id: " + id));

        status.setStatus(updatedStatus.getStatus());
        status.setDataInicio(updatedStatus.getDataInicio() != null ? updatedStatus.getDataInicio() : new Date());

        statusRepository.save(status);

        // Envia mensagem via WebSocket
        messagingTemplate.convertAndSend("/topic/status/" + id, status);

        return ResponseEntity.ok("Status atualizado com sucesso");
    }
}
