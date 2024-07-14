package com.fiap.soat.foodsystem.modules.domain.model;

import java.math.BigDecimal;

public class PedidoProduto {

    private Pedido pedido;
    private Produto produto;
    private Integer qtdeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;

    public PedidoProduto() {
    }

    public PedidoProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(Integer qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
