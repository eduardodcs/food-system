package com.fiap.soat.services;

import com.fiap.soat.entities.FilaPreparo;
import com.fiap.soat.entities.Pedido;
import com.fiap.soat.ports.FilaPreparoRepositoryPort;
import com.fiap.soat.ports.FilaPreparoServicePort;

import java.time.LocalDateTime;

public class FilaPedidoService implements FilaPreparoServicePort {

    private FilaPreparoRepositoryPort filaPreparoRepositoryPort;

    public FilaPedidoService(FilaPreparoRepositoryPort filaPreparoRepositoryPort) {
        this.filaPreparoRepositoryPort = filaPreparoRepositoryPort;
    }

    @Override
    public void enviarPedidoParaFilaPreparo(Pedido pedido) {
        FilaPreparo filaPreparo = new FilaPreparo();
        filaPreparo.setPedido(pedido);
        filaPreparo.setDataHoraCriacao(LocalDateTime.now());
        this.filaPreparoRepositoryPort.enviarPedidoParaFilaPreparo(filaPreparo);
    }
}
