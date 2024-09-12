package com.oficina.oficinacarro.model;

import com.oficina.oficinacarro.enums.stateCar;
import jakarta.persistence.*;

@Entity(name = "VeiculoModel")
@Table(name = "veiculo", schema = "oficina")
public class VeiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;
    @Column(name = "veiculo",nullable = false)
    private String veiculo;
    @Column(name = "placa",nullable = false)
    private String placa;
    @Column(name = "modelo",nullable = false)
    private String modelo;
    @Column(name = "ano",nullable = false)
    private int ano;


    public VeiculoModel() {
    }

    public VeiculoModel(int id, ClienteModel cliente, String veiculo, String placa, String modelo, int ano) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public static void main(String[] args) {
        VeiculoModel veiculoModel = new VeiculoModel();
        String status = stateCar.etapa_2.getState();
        System.out.println(status);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
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
}
