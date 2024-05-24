package com.fiap.soat.foodsystem.domain.model;

import com.fiap.soat.foodsystem.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private List<PedidoProduto> listaPedidoProdutos;
    private StatusEnum status;
    private BigDecimal valorTotalPedido;
    private LocalDateTime dataHoraCriacao;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoProduto> getListaPedidoProdutos() {
        return listaPedidoProdutos;
    }

    public void setListaPedidoProdutos(List<PedidoProduto> listaPedidoProdutos) {
        this.listaPedidoProdutos = listaPedidoProdutos;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
}
