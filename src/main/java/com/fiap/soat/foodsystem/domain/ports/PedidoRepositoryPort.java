package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.enums.StatusEnum;
import com.fiap.soat.foodsystem.domain.model.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> listarPedidoPorStatus(StatusEnum status);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido);

    void cancelarPedido(Pedido pedido);

}
