package com.fiap.soat.ports.usecases;

import com.fiap.soat.entities.Pedido;

public interface FilaPreparoUseCasePort {
    void enviarPedidoParaFilaPreparo(Pedido pedido);

}
