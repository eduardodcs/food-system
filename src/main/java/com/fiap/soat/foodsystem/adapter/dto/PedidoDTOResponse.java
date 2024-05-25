package com.fiap.soat.foodsystem.adapter.dto;

import com.fiap.soat.foodsystem.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTOResponse {

    private Long id;
    private ClienteDTO cliente;
    private List<PedidoProdutoDTOResponse> listaPedidoProduto;
    private StatusPedido statusPedido;
    private StatusPagamento statusPagamento;
    private BigDecimal valorTotal;
    private LocalDateTime dataHoraCriacao;
    private String observacao;
    private String qRCode;
    
}
