package com.fiap.soat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoProdutoDTOResponse {

    private ProdutoDTOResponse produto;
    private Integer qtdeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;

}
