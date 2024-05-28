package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.model.Pedido;

public interface FilaPreparoServicePort {
    void enviarPedidoParaFilaPreparo(Pedido pedido);

}
