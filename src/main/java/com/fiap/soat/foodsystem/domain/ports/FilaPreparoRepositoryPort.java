package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.model.FilaPreparo;

public interface FilaPreparoRepositoryPort {

    void enviarPedidoParaFilaPreparo(FilaPreparo filaPreparo);
}
