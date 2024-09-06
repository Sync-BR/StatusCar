package com.oficina.oficinacarro.model;

import com.oficina.oficinacarro.enums.UsersEnums;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;


@Entity(name = "AutenticacaoModel")
@Table(name = "cliente", schema = "oficina")
public class AutenticacaoModel {
    @Column(name = "login", nullable = false)
    private String usuario;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "rank", nullable = false)
    private UsersEnums rank;
    @Id
    private Long id;

    public AutenticacaoModel() {

    }
    public AutenticacaoModel(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "AutenticacaoModel{" +
                "usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", rank=" + rank +
                ", id=" + id +
                '}';
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
