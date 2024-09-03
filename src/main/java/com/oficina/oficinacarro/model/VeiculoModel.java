package com.oficina.oficinacarro.model;

public class VeiculoModel {
    private int id;
    private ClienteModel cliente;
    private String veiculo;
    private String placa;
    private String modelo;
    private int ano;

    public VeiculoModel() {
    }

    @Override
    public String toString() {
        return "VeiculoModel{" +
                "id=" + id +
                ", cliente=" + cliente +
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
