package com.fiap.soat.foodsystem.modules.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoProdutoDTOReceived {

    @NumberFormat
    @NotNull(message = "Id do produto não pode ser nulo")
    private Long idProduto;
    @NumberFormat
    @NotNull(message = "Quantidade não pode ser nula")
    private Integer qtdeProduto;
    @NumberFormat
    @NotNull(message = "Preço unitário não pode ser nulo")
    private BigDecimal precoUnitario;
    @NumberFormat
    private BigDecimal subTotal;
}
