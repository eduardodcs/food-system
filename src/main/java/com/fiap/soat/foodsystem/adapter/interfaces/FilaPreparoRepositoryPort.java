package com.fiap.soat.foodsystem.adapter.interfaces;

import com.fiap.soat.foodsystem.modules.domain.model.FilaPreparo;

public interface FilaPreparoRepositoryPort {

    void enviarPedidoParaFilaPreparo(FilaPreparo filaPreparo);
}
