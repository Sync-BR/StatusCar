package com.oficina.oficinacarro.model;

import com.oficina.oficinacarro.enums.UsersEnums;
import jakarta.persistence.*;


@Entity(name = "AutenticacaoModel")
@Table(name = "autenticacao", schema = "oficinacarro")
public class AutenticacaoModel {
    @Id
    @Column(name = "id_cliente_aut")
    private int id;
    @Column(name = "cpf_cliente_aut", nullable = false)
    private String cpf;
    @Column(name = "senha_cliente_aut", nullable = false)
    private String senha;


    public AutenticacaoModel() {
    }



    @Override
    public String toString() {
        return "AutenticacaoModel{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
