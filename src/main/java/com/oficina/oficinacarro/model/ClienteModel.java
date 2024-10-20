package com.oficina.oficinacarro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oficina.oficinacarro.enums.UsersEnums;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "ClienteModel")
@Table(name = "cliente", schema = "oficina")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome_cliente", nullable = false)
    private String nome;
    @Column(name = "cpf_cliente", nullable = false, unique = true)
    private String cpf;
    @Column(name = "telefone_cliente", nullable = false)
    private String telefone;
    @Column(name = "email_cliente", nullable = false)
    private String email;
    @Column(name = "endereco_cliente", nullable = false)
    private String endereco;
    @Column(name = "senha_cliente", nullable = false)
    private String senha;
    @Column(name = "tipo_usuario", nullable = true)
    private UsersEnums rank;
    @OneToMany(mappedBy = "clienteID", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonIgnore()
    private List<VeiculoModel> veiculos;


    public ClienteModel() {
        veiculos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", senha='" + senha + '\'' +
                ", rank=" + rank +
                ", veiculos=" + veiculos +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public List<VeiculoModel> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoModel> veiculos) {
        this.veiculos = veiculos;
    }
}
