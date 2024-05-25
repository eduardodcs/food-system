package com.fiap.soat.foodsystem.adapter.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @Column(nullable = false)
    private String nome;
    private String telefone;
    private String email;
    private boolean flagAtivo;

    public ClienteEntity() {
    }

    public ClienteEntity(String cpf, String nome, String telefone, String email, boolean flagAtivo) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.flagAtivo = flagAtivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean isFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
}
