package com.fiap.soat.ports.gateways;

import com.fiap.soat.enums.StatusPedido;
import com.fiap.soat.entities.Pedido;

import java.util.List;

public interface PedidoGatewayPort {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> listarPedidoPorStatus(StatusPedido status);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido);

    void cancelarPedido(Pedido pedido);

}
