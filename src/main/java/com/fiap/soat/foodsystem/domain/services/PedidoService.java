package com.fiap.soat.foodsystem.domain.services;

import com.fiap.soat.foodsystem.common.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.enums.StatusEnum;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.ports.PedidoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.PedidoServicePort;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PedidoService implements PedidoServicePort {

    private PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    @Transactional
    public Pedido salvarPedido(Pedido pedido) {
        pedido.setValorTotalPedido(BigDecimal.ZERO);
        pedido.getListaPedidoProdutos().stream().forEach(pedidoProduto -> {
            pedidoProduto.setSubTotal(pedidoProduto.getPrecoUnitario().multiply(BigDecimal.valueOf(pedidoProduto.getQtdeProduto())));
            pedido.getValorTotalPedido().add(pedidoProduto.getSubTotal());
        });
        pedido.setStatus(StatusEnum.RECEBIDO);
        pedido.setDataHoraCriacao(LocalDateTime.now());
        return this.pedidoRepositoryPort.criarPedido(pedido);
    }

    @Override
    public List<Pedido> buscarPedidoPorStatus(Integer status) {
        StatusEnum statusEnum = Arrays.stream(StatusEnum.values()).filter(x -> x.ordinal() == status.intValue()).findFirst()
                .orElseThrow(() -> new NotFoundException("Status inválido"));
        return this.pedidoRepositoryPort.listarPedidoPorStatus(statusEnum);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return this.pedidoRepositoryPort.buscarPedidoPorId(id);
    }

    @Override
    @Transactional
    public Pedido atualizarPedido(Pedido pedido) {
        return this.pedidoRepositoryPort.atualizarPedido(pedido);
    }

    @Override
    @Transactional
    public void cancelarPedido(Long id) {
        Pedido pedido = this.buscarPedidoPorId(id);
        pedido.setStatus(StatusEnum.CANCELADO);
        this.pedidoRepositoryPort.cancelarPedido(pedido);
    }
}
