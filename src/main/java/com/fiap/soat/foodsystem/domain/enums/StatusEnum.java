package com.fiap.soat.foodsystem.domain.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    ;

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

}
