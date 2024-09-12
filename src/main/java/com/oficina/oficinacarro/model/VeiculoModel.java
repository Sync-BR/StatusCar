package com.oficina.oficinacarro.model;

import com.oficina.oficinacarro.enums.StateCar;
import jakarta.persistence.*;

@Entity(name = "VeiculoModel")
@Table(name = "veiculo", schema = "oficina")
public class VeiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cliente_id", nullable = false)
    private int clienteID;
    @Column(name = "veiculo",nullable = false)
    private String veiculo;
    @Column(name = "placa",nullable = false)
    private String placa;
    @Column(name = "modelo",nullable = false)
    private String modelo;
    @Column(name = "ano",nullable = false)
    private int ano;
    @Column(name="status", nullable = false)
    private StateCar stateCar;



    public VeiculoModel() {
        stateCar = StateCar.Ausente;
    }

    @Override
    public String toString() {
        return "VeiculoModel{" +
                "id=" + id +
                ", clienteID=" + clienteID +
                ", veiculo='" + veiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
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

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public StateCar getStateCar() {
        return stateCar;
    }

    public void setStateCar(StateCar stateCar) {
        this.stateCar = stateCar;
    }

    public static void main(String[] args) {
        VeiculoModel veiculoModel = new VeiculoModel();
        String status = StateCar.etapa_2.getState();
        System.out.println(status);

    }



}
