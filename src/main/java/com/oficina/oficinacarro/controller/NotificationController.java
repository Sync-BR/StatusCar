package com.oficina.oficinacarro.controller;

import com.oficina.oficinacarro.model.ClienteModel;
import com.oficina.oficinacarro.model.NotificationModel;
import com.oficina.oficinacarro.model.VeiculoModel;
import com.oficina.oficinacarro.repository.ClienteRepository;
import com.oficina.oficinacarro.repository.NotificationRepository;
import com.oficina.oficinacarro.repository.StatusRepository;
import com.oficina.oficinacarro.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notification")
    public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private StatusRepository statusRepository;

    @PostMapping("/enviar")
    public ResponseEntity<HttpStatus> criarNotificacao(@RequestBody NotificationModel notificationRequest) {
        System.out.println("Noticação chegando " +notificationRequest);
        System.out.println("Dados da notificação: " + notificationRequest);
        notificationRequest.setData(new Date());
        NotificationModel notification = new NotificationModel(notificationRequest.getId_Veiculo(), notificationRequest.getId_Status(), notificationRequest.getDescricao());
        NotificationModel savedNotification = notificationRepository.save(notification);
        if (savedNotification != null) {
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    private VeiculoModel getVeiculoByPlaca(String placa) {
        VeiculoModel veiculo = veiculoRepository.findByplaca(placa);
        System.out.println(veiculo);
        return veiculo;
    }

    @DeleteMapping("/delete/{Placa}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable String Placa) {
        VeiculoModel veiculo = getVeiculoByPlaca(Placa);
        System.out.println(veiculo);
        int response = notificationRepository.deleteByIdVeiculo(veiculo.getId());
        if (response > 0) {
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/delete/by/{id}")
    public ResponseEntity<HttpStatus> deleteVeiculoById(@PathVariable  int id) {
        System.out.println("ID Notificação " +id);
       // int sucess = notificationRepository.deleteByIdVeiculo(id);
        notificationRepository.deleteById((long) id);
//        if (sucess > 0) {
//            return ResponseEntity.ok(HttpStatus.OK);
//        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/consultar/{Placa}")
    public ResponseEntity<NotificationModel> getNotifications(@PathVariable String Placa) {
        VeiculoModel veiculo = getVeiculoByPlaca(Placa);
        List<NotificationModel> notificationModel = notificationRepository.findById_Veiculo(veiculo.getId());
        NotificationModel notificao = new NotificationModel();
        for(NotificationModel notification : notificationModel){
            notificao = notification;
            break;
        }
        if (notificationModel != null) {

            return ResponseEntity.ok(notificao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/consultarID/{cpf}")
    public ResponseEntity<Integer> getVeiculoID(@PathVariable String cpf) {
        ClienteModel clienteModel = new ClienteModel();
        VeiculoModel veiculoModel = new VeiculoModel();
        clienteModel = clienteRepository.findByCpf(cpf);
        if (clienteModel != null) {
            veiculoModel =  veiculoRepository.findByclienteID(clienteModel.getId());
            if(veiculoModel != null) {
                List<NotificationModel> notificationModel = notificationRepository.findById_Veiculo(veiculoModel.getId());
                if(notificationModel.size() != 0) {
                    System.out.println("ID" +veiculoModel.getId());
                    System.out.println("Retornando id" +notificationModel);
                    return ResponseEntity.ok(veiculoModel.getId());

                } else{
                    System.out.println("nada encontrado!");
                    return ResponseEntity.status(HttpStatus.OK).build();
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}


