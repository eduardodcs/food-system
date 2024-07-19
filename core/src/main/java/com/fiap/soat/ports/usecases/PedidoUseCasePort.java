package com.fiap.soat.ports.usecases;

import com.fiap.soat.entities.Pedido;

import java.util.List;

public interface PedidoUseCasePort {

    Pedido salvarPedido(Pedido pedido);

    List<Pedido> buscarPedidoPorStatus(Integer status);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido);

    void cancelarPedido(Long id);

    void confirmarPagamento(Long id);
}
