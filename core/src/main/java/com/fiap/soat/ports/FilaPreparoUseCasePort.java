package com.fiap.soat.ports;

import com.fiap.soat.entities.Pedido;

public interface FilaPreparoUseCasePort {
    void enviarPedidoParaFilaPreparo(Pedido pedido);

}
