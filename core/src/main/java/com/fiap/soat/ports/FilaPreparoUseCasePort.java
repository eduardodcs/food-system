package com.fiap.soat.ports;

import com.fiap.soat.entities.Pedido;

public interface FilaPreparoServicePort {
    void enviarPedidoParaFilaPreparo(Pedido pedido);

}
