package com.fiap.soat.mapper;

import com.fiap.soat.entities.*;
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

    public PedidoEntity pedidoToPedidoEntity(Pedido pedido) {
        PedidoEntity pedidoEntity = mapper.map(pedido, PedidoEntity.class);
        ClienteEntity clienteEntity = clienteMapper.clienteToClienteEntity(pedido.getCliente());
        List<PedidoProdutoEntity> listaPedidoProdutoEntity = pedido.getListaPedidoProdutos().stream()
                .map(pedidoProduto -> pedidoProdutoMapper.pedidoProdutoToPedidoProdutoEntity(pedidoProduto, pedidoEntity)).toList();
        pedidoEntity.setCliente(clienteEntity);
        pedidoEntity.setCliente_id(clienteEntity.getId());
        pedidoEntity.setListaPedidoProdutos(listaPedidoProdutoEntity);
        return pedidoEntity;
    }

    public Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoEntity.getId());
        pedido.setCliente(clienteMapper.clienteEntityToCliente(pedidoEntity.getCliente()));
        pedido.setStatusPedido(pedidoEntity.getStatusPedido());
        pedido.setStatusPagamento(pedidoEntity.getStatusPagamento());
        pedido.setValorTotalPedido(pedidoEntity.getValorTotal());
        pedido.setDataHoraCriacao(pedidoEntity.getDataHoraCriacao());
        pedido.setObservacao(pedidoEntity.getObservacao());
        List<PedidoProduto> listaPedidoProduto = pedidoEntity.getListaPedidoProdutos().stream()
                .map(pedidoProdutoEntity -> pedidoProdutoMapper.pedidoProdutoEntityToPedidoProduto(pedidoProdutoEntity, pedido)).toList();
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return pedido;
    }
}
