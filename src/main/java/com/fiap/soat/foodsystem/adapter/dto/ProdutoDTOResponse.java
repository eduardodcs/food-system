package com.fiap.soat.foodsystem.adapter.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTOResponse {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaDTO categoriaDTO;
    private boolean statusAtivo;
    private LocalDateTime dataHoraCriacao;
}
