package com.fiap.soat.mapper;

import com.fiap.soat.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoProdutoMapper {

    @Autowired
    private ModelMapper mapper;

    public PedidoProdutoEntity pedidoProdutoToPedidoProdutoEntity(PedidoProduto pedidoProduto, PedidoEntity pedidoEntity) {
        PedidoProdutoEntity pedidoProdutoEntity = new PedidoProdutoEntity();
        pedidoProdutoEntity.setId(new PedidoProdutoEntityId());
        pedidoProdutoEntity.getId().setPedido_id(pedidoEntity);
        pedidoProdutoEntity.getId().setProduto_id(mapper.map(pedidoProduto.getProduto(), ProdutoEntity.class));
        pedidoProdutoEntity.setPedido_id(pedidoEntity.getId());
        pedidoProdutoEntity.setProduto_id(pedidoProduto.getProduto().getId());
        pedidoProdutoEntity.setQtdeProduto(pedidoProduto.getQtdeProduto());
        pedidoProdutoEntity.setSubTotal(pedidoProduto.getSubTotal());
        pedidoProdutoEntity.setPrecoUnitario(pedidoProduto.getPrecoUnitario());
        return pedidoProdutoEntity;
    }

    public PedidoProduto pedidoProdutoEntityToPedidoProduto(PedidoProdutoEntity pedidoProdutoEntity, Pedido pedido) {
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setProduto(this.mapper.map(pedidoProdutoEntity.getId().getProduto_id(), Produto.class));
        pedidoProduto.getProduto().setCategoria(this.mapper.map(pedidoProdutoEntity.getId().getProduto_id().getCategoria(), Categoria.class));
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setSubTotal(pedidoProdutoEntity.getSubTotal());
        pedidoProduto.setQtdeProduto(pedidoProdutoEntity.getQtdeProduto());
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setPrecoUnitario(pedidoProdutoEntity.getPrecoUnitario());
        return pedidoProduto;
    }

}
