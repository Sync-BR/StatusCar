package com.oficina.oficinacarro.model;

import com.oficina.oficinacarro.enums.StateCar;
import jakarta.persistence.*;

@Entity(name = "VeiculoModel")
@Table(name = "veiculo", schema = "oficinacarro")
public class VeiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private int id;
    @Column(name = "id_cliente", nullable = false)
    private int clienteID;
    @Column(name = "modelo_veiculo",nullable = false)
    private String modelo;
    @Column(name = "placa_veiculo",nullable = false)
    private String placa;
    @Column(name = "marca_veiculo", nullable = false)
    private String marca;
    @Column(name = "ano_veiculo",nullable = false)
    private int ano;

    public VeiculoModel() {
    }

    @Override
    public String toString() {
        return "VeiculoModel{" +
                "id=" + id +
                ", clienteID=" + clienteID +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
