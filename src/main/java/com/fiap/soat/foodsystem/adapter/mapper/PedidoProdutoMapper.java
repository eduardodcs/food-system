package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.modules.domain.entities.PedidoEntity;
import com.fiap.soat.foodsystem.modules.domain.entities.PedidoProdutoEntity;
import com.fiap.soat.foodsystem.modules.domain.entities.PedidoProdutoEntityId;
import com.fiap.soat.foodsystem.modules.domain.entities.ProdutoEntity;
import com.fiap.soat.foodsystem.modules.domain.model.Categoria;
import com.fiap.soat.foodsystem.modules.domain.model.Pedido;
import com.fiap.soat.foodsystem.modules.domain.model.PedidoProduto;
import com.fiap.soat.foodsystem.modules.domain.model.Produto;
import com.fiap.soat.foodsystem.modules.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProdutoMapper {

    @Autowired
    private ModelMapper mapper;

    public PedidoProdutoDTOResponse peditoProdutoToPedidoProdutoDTOResponse(PedidoProduto pedidoProduto, PedidoDTOResponse pedidoDTOResponse) {
        PedidoProdutoDTOResponse pedidoProdutoDTOResponse = mapper.map(pedidoProduto, PedidoProdutoDTOResponse.class);
        pedidoProdutoDTOResponse.setProduto(mapper.map(pedidoProduto.getProduto(), ProdutoDTOResponse.class));
        pedidoProdutoDTOResponse.getProduto().setCategoriaDTO(this.mapper.map(pedidoProduto.getProduto().getCategoria(), CategoriaDTO.class));
        return pedidoProdutoDTOResponse;
    }

    public PedidoProduto pedidoProdutoDTOResponseToPedidoProduto(PedidoProdutoDTOResponse pedidoProdutoDTOResponse) {
        return mapper.map(pedidoProdutoDTOResponse, PedidoProduto.class);
    }

    public PedidoProduto pedidoProdutoDTOReceivedTOPedidoProduto(PedidoProdutoDTOReceived pedidoProdutoDTOReceived) {
        return mapper.map(pedidoProdutoDTOReceived, PedidoProduto.class);
    }

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
