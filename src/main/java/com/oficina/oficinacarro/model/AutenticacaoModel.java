package com.oficina.oficinacarro.model;

import com.oficina.oficinacarro.enums.UsersEnums;
import jakarta.persistence.*;


@Entity(name = "AutenticacaoModel")
@Table(name = "cliente", schema = "oficina")
public class AutenticacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", nullable = false)
    private String usuario;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "rank", nullable = false)
    private UsersEnums rank;
    @Column(name = "cpf", nullable = false)
    private String cpf;

    public AutenticacaoModel() {

    }

    @Override
    public String toString() {
        return "AutenticacaoModel{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", rank=" + rank +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsersEnums getRank() {
        return rank;
    }

    public void setRank(UsersEnums rank) {
        this.rank = rank;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
