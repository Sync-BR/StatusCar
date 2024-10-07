package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.StatusModel;
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
    private SimpMessagingTemplate messagingTemplate;

    public void addStatusDefault(StatusModel statusModel){
        statusRepository.save(statusModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusModel> getStatusById(@PathVariable int id) {
        StatusModel status = statusRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado para o id: " + id));
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody StatusModel updatedStatus) {
        StatusModel status = statusRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado para o id: " + id));

        status.setStatus(updatedStatus.getStatus());
        status.setDataInicio(updatedStatus.getDataInicio() != null ? updatedStatus.getDataInicio() : new Date());
        status.setDataFim(updatedStatus.getDataFim());

        statusRepository.save(status);

        // Envia mensagem via WebSocket
        messagingTemplate.convertAndSend("/topic/status/" + id, status);

        return ResponseEntity.ok("Status atualizado com sucesso");
    }
}
