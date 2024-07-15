package com.fiap.soat.usecases;

import com.fiap.soat.entities.FilaPreparo;
import com.fiap.soat.entities.Pedido;
import com.fiap.soat.ports.gateways.FilaPreparoGatewayPort;
import com.fiap.soat.ports.usecases.FilaPreparoUseCasePort;

import java.time.LocalDateTime;

public class FilaPedidoUseCase implements FilaPreparoUseCasePort {

    private FilaPreparoGatewayPort filaPreparoGatewayPort;

    public FilaPedidoUseCase(FilaPreparoGatewayPort filaPreparoGatewayPort) {
        this.filaPreparoGatewayPort = filaPreparoGatewayPort;
    }

    @Override
    public void enviarPedidoParaFilaPreparo(Pedido pedido) {
        FilaPreparo filaPreparo = new FilaPreparo();
        filaPreparo.setPedido(pedido);
        filaPreparo.setDataHoraCriacao(LocalDateTime.now());
        this.filaPreparoGatewayPort.enviarPedidoParaFilaPreparo(filaPreparo);
    }
}
