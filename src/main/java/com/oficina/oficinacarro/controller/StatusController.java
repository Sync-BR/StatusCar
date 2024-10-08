package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.repository.StatusRepository;
import com.oficina.oficinacarro.service.StatusService;
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
    private StatusService statusService;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Método para adicionar um status padrão
    public void addStatusDefault(StatusModel id){
        statusService.addStatus(id);
    }

    // Buscar status por ID
    @GetMapping("/{id}")
    public ResponseEntity<StatusModel> getStatusById(@PathVariable int id) {
        StatusModel status = statusService.getStatusById(id);
        return ResponseEntity.ok(status);
    }

    // Atualizar status por ID
    @PostMapping("/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody StatusModel updatedStatus) {
        statusService.updateStatus(id, updatedStatus);

        // Envia mensagem via WebSocket
        messagingTemplate.convertAndSend("/topic/status/" + id, updatedStatus);

        return ResponseEntity.ok("Status atualizado com sucesso");
    }
}
