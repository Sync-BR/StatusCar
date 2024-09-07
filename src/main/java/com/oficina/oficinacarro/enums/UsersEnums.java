package com.oficina.oficinacarro.enums;

public enum UsersEnums {
    usuario("cliente"),
    consultore("Consultores"),
    administrador("Administradores"),
    desenvolvimento("Desenvolvedor");

    private String rank;

    UsersEnums(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
