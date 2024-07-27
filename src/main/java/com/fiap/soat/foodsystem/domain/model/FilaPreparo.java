package com.fiap.soat.foodsystem.domain.model;

import java.time.LocalDateTime;

public class FilaPreparo {

    private Long id;
    private Pedido pedido;
    private LocalDateTime dataHoraCriacao;

    public FilaPreparo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
}
