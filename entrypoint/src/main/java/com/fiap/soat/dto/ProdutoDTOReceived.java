package com.fiap.soat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTOReceived {

    @NumberFormat
    private Long id;

    @NotBlank(message = "Nome do produto não pode ser vazio")
    @NotNull(message = "Nome do produto não pode ser nulo")
    @Size(min = 3, max = 80, message = "Nome do produto deve ter entre 3 e 80 caracteres")
    private String nome;

    @NotBlank(message = "Descrição não pode ser vazia")
    @NotNull(message = "Descrição não pode ser nula")
    @Size(min = 3, max = 500, message = "Descrição deve ter entre 3 e 500 caracteres")
    private String descricao;

    @NotNull(message = "Preço não pode ser nulo")
    @NumberFormat
    private BigDecimal preco;

    @NotNull(message = "Categoria não pode ser nula")
    @NumberFormat
    private Long idCategoria;

    private boolean statusAtivo;
}
