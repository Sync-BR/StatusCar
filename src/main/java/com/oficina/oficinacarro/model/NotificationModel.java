package com.oficina.oficinacarro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "NotificationModel")
@Table(name = "notificacao", schema = "oficinacarro")
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao", nullable = false)
    private int id_Notification;
    @Column(name = "id_veiculo", nullable = false)
    private int id_Veiculo;
    @Column(name = "id_status", nullable = false)
    private int id_Status;
    @Column(name = "descricao_notificacao", nullable = false)
    private String descricao;
    @Column(name = "data_hora_notificacao", nullable = false)
    @JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss a", locale = "en_US")

    private Date data;

    public NotificationModel() {
    }


    public NotificationModel( int id_Veiculo, int id_Status, String descricao) {
        this.id_Veiculo = id_Veiculo;
        this.id_Status = id_Status;
        this.descricao = descricao;
        this.data = new Date();
    }


    public static void main(String[] args) {
        NotificationModel notificacao = new NotificationModel(1,1,"teste");
        System.out.println(notificacao);
    }
    @Override
    public String toString() {
        return "NotificationModel{" +
                "id_Notification=" + id_Notification +
                ", id_Veiculo=" + id_Veiculo +
                ", id_Status=" + id_Status +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                '}';
    }

    public int getId_Notification() {
        return id_Notification;
    }

    public void setId_Notification(int id_Notification) {
        this.id_Notification = id_Notification;
    }

    public int getId_Veiculo() {
        return id_Veiculo;
    }

    public void setId_Veiculo(int id_Veiculo) {
        this.id_Veiculo = id_Veiculo;
    }

    public int getId_Status() {
        return id_Status;
    }

    public void setId_Status(int id_Status) {
        this.id_Status = id_Status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
