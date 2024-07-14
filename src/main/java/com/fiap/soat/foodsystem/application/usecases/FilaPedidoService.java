package com.fiap.soat.foodsystem.application.usecases;

import com.fiap.soat.foodsystem.modules.domain.model.FilaPreparo;
import com.fiap.soat.foodsystem.modules.domain.model.Pedido;
import com.fiap.soat.foodsystem.adapter.interfaces.FilaPreparoRepositoryPort;
import com.fiap.soat.foodsystem.adapter.interfaces.FilaPreparoServicePort;

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
