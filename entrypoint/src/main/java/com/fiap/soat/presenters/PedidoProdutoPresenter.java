package com.fiap.soat.mapper;

import com.fiap.soat.dto.*;
import com.fiap.soat.entities.PedidoProduto;
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

}
