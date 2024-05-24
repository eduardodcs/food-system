package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.adapter.dto.PedidoDTO;
import com.fiap.soat.foodsystem.adapter.dto.PedidoProdutoDTO;
import com.fiap.soat.foodsystem.adapter.entities.PedidoEntity;
import com.fiap.soat.foodsystem.adapter.entities.PedidoProdutoEntity;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.model.PedidoProduto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProdutoMapper {

    @Autowired
    private ModelMapper mapper;

    public PedidoProdutoDTO peditoProdutoToPedidoProdutoDTO(PedidoProduto pedidoProduto, PedidoDTO pedidoDTO) {
        PedidoProdutoDTO pedidoProdutoDTO = mapper.map(pedidoProduto, PedidoProdutoDTO.class);
        return pedidoProdutoDTO;
    }

    public PedidoProduto pedidoProdutoDTOToPedidoProduto(PedidoProdutoDTO pedidoProdutoDTO) {
        return mapper.map(pedidoProdutoDTO, PedidoProduto.class);
    }

    public PedidoProdutoEntity pedidoProdutoToPedidoProdutoEntity(PedidoProduto pedidoProduto, PedidoEntity pedidoEntity) {
        PedidoProdutoEntity pedidoProdutoEntity = mapper.map(pedidoProduto, PedidoProdutoEntity.class);
        pedidoProdutoEntity.setPedido_id(pedidoEntity.getId());
        pedidoProdutoEntity.setProduto_id(pedidoProduto.getProduto().getId());
        return pedidoProdutoEntity;
    }

    public PedidoProduto pedidoProdutoEntityToPedidoProduto(PedidoProdutoEntity pedidoProdutoEntity, Pedido pedido) {
        PedidoProduto pedidoProduto = mapper.map(pedidoProdutoEntity, PedidoProduto.class);
        pedidoProduto.setPedido(pedido);
        return pedidoProduto;
    }

}
