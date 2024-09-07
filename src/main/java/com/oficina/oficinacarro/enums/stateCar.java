package com.oficina.oficinacarro.enums;

public enum stateCar {
    etapa_1("Veículo em espera"),
    etapa_2("Veículo em análise"),
    etapa_3("Veículo em manutenção"),
    etapa_4("Veículo finalizado");

    private String state;
    private stateCar(String state) {
        this.state = state;
    }
    private stateCar(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static void main(String[] args) {
        String estado = stateCar.etapa_1.getState();
        System.out.println(estado);

    }
}
