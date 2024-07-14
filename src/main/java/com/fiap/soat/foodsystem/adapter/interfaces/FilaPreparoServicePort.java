package com.fiap.soat.foodsystem.adapter.interfaces;

import com.fiap.soat.foodsystem.modules.domain.model.Pedido;

public interface FilaPreparoServicePort {
    void enviarPedidoParaFilaPreparo(Pedido pedido);

}
