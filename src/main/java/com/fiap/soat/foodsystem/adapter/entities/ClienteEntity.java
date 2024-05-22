package com.fiap.soat.foodsystem.adapter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Cliente")
@Data
public class ClienteEntity {

    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private boolean flagAtivo;

}
