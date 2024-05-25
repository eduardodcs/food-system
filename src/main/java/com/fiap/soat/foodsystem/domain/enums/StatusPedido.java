package com.fiap.soat.foodsystem.domain.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {

    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    ;

    private String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

}
