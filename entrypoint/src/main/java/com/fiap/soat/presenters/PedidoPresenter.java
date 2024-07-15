package com.fiap.soat.mapper;


import com.fiap.soat.dto.ClienteDTO;
import com.fiap.soat.dto.PedidoDTOReceived;
import com.fiap.soat.dto.PedidoDTOResponse;
import com.fiap.soat.dto.PedidoProdutoDTOResponse;
import com.fiap.soat.entities.Cliente;
import com.fiap.soat.entities.Pedido;
import com.fiap.soat.entities.PedidoProduto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PedidoProdutoMapper pedidoProdutoMapper;

    public Pedido pedidoDTOResponseToPedido(PedidoDTOResponse pedidoDTOResponse) {
        Cliente cliente = clienteMapper.clienteDTOToCliente(pedidoDTOResponse.getCliente());
        List<PedidoProduto> listaPedidoProduto = pedidoDTOResponse.getListaPedidoProduto().stream()
                .map(pedidoProdutoDTOResponse -> pedidoProdutoMapper.pedidoProdutoDTOResponseToPedidoProduto(pedidoProdutoDTOResponse)).toList();
        Pedido pedido = mapper.map(pedidoDTOResponse, Pedido.class);
        pedido.setCliente(cliente);
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return pedido;
    }

    public PedidoDTOResponse pedidoToPedidoDTOResponse(Pedido pedido) {
        PedidoDTOResponse pedidoDTOResponse = mapper.map(pedido, PedidoDTOResponse.class);
        ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(pedido.getCliente());
        List<PedidoProdutoDTOResponse> listaPedidoProdutoDTOResponse = pedido.getListaPedidoProdutos().stream()
                .map(pedidoProduto -> pedidoProdutoMapper.peditoProdutoToPedidoProdutoDTOResponse(pedidoProduto, pedidoDTOResponse)).toList();
        pedidoDTOResponse.setCliente(clienteDTO);
        pedidoDTOResponse.setListaPedidoProduto(listaPedidoProdutoDTOResponse);
        return pedidoDTOResponse;
    }

    public Pedido pedidoDTOReceivedToPedido(PedidoDTOReceived pedidoDTOReceived) {
        return mapper.map(pedidoDTOReceived, Pedido.class);
    }

}
