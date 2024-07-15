package com.fiap.soat.ports.gateways;

import com.fiap.soat.entities.FilaPreparo;

public interface FilaPreparoGatewayPort {

    void enviarPedidoParaFilaPreparo(FilaPreparo filaPreparo);
}
