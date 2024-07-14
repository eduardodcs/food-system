package com.fiap.soat.foodsystem.adapter.interfaces;

import com.fiap.soat.foodsystem.modules.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.modules.domain.model.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> listarPedidoPorStatus(StatusPedido status);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido);

    void cancelarPedido(Pedido pedido);

}
