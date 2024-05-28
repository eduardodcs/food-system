package com.fiap.soat.foodsystem.domain.services;

import com.fiap.soat.foodsystem.adapter.infra.repository.FilaPreparoRepository;
import com.fiap.soat.foodsystem.domain.model.FilaPreparo;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.ports.FilaPreparoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.FilaPreparoServicePort;

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
