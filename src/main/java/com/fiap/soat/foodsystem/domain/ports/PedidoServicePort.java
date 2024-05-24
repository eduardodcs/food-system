package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.model.Pedido;

import java.util.List;

public interface PedidoServicePort {

    Pedido salvarPedido(Pedido pedido);

    List<Pedido> buscarPedidoPorStatus(Integer status);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido);

    void cancelarPedido(Long id);
}
