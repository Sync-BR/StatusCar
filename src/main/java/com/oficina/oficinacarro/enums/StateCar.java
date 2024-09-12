package com.oficina.oficinacarro.enums;

public enum StateCar {
    Ausente("Veículo em espera"),
    etapa_2("Veículo em análise"),
    etapa_3("Veículo em manutenção"),
    etapa_4("Veículo finalizado");

    private String state;
    private StateCar(String state) {
        this.state = state;
    }
    private StateCar(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static void main(String[] args) {
        String estado = StateCar.etapa_4.getState();
        System.out.println(estado);

    }
}
