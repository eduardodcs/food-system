package com.fiap.soat.ports;

import com.fiap.soat.entities.FilaPreparo;

public interface FilaPreparoRepositoryPort {

    void enviarPedidoParaFilaPreparo(FilaPreparo filaPreparo);
}
