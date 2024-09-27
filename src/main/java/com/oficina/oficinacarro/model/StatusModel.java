package com.oficina.oficinacarro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity(name = "Status")
@Table(name = "status", schema = "oficinacarro")
public class StatusModel {
    @Id
    @Column(name = "id_status", nullable = false)
    private int id;

    @Column(name = "descricao_status", nullable = false)
    private String status;

    @Column(name = "data_inicio_status", nullable = false)
    private Date dataInicio;

    @Column(name = "data_fim_status")
    private Date dataFim;


    public StatusModel(int id, String emAnalise) {
    }

    public StatusModel(int id, String status, Date dataInicio, Date dataFim) {
        this.id = id;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "StatusModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
