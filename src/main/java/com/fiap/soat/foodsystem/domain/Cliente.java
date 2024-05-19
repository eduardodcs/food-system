package com.fiap.soat.foodsystem.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

}