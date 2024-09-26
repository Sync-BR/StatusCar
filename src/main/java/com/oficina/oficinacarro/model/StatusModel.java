package com.oficina.oficinacarro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Status")
@Table(name = "status", schema = "oficinacarro")
public class StatusModel {
    @Id
    @Column(name = "id_status", nullable = false)
    private int id;
    @Column(name = "descricao_status", nullable = false)
    private String status;

    public StatusModel() {
    }

    public StatusModel(int id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
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
}
