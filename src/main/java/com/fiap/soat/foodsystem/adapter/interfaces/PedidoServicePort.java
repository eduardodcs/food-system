package com.fiap.soat.foodsystem.adapter.interfaces;

import com.fiap.soat.foodsystem.modules.domain.model.Pedido;

import java.util.List;

public interface PedidoServicePort {

    Pedido salvarPedido(Pedido pedido);

    List<Pedido> buscarPedidoPorStatus(Integer status);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido);

    void cancelarPedido(Long id);

    void confirmarPagamento(Long id);
}
