package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    public void addStatusDefault(StatusModel statusModel){
        statusRepository.save(statusModel);
    }
}
