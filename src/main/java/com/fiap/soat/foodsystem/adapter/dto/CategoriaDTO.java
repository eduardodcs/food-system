package com.fiap.soat.foodsystem.adapter.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {

    private Long id;

    @NotBlank
    private String nome;

    private boolean statusAtivo;
}
