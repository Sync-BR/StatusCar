package com.oficina.oficinacarro.service;

import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.repository.StatusRepository;
import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    // Buscar status por ID
    public StatusModel getStatusById(int id) {
        return statusRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado para o id: " + id));
    }

    // Atualizar status
    public void updateStatus(int id, StatusModel updatedStatus) {
        StatusModel status = statusRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado para o id: " + id));

        status.setStatus(updatedStatus.getStatus());
        status.setDataInicio(updatedStatus.getDataInicio() != null ? updatedStatus.getDataInicio() : new Date());
        status.setDataFim(updatedStatus.getDataFim());

        statusRepository.save(status);
    }

    // Adicionar novo status
    public void addStatus(StatusModel statusModel) {
        statusRepository.save(statusModel);
    }
}

