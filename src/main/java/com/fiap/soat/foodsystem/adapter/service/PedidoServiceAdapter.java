package com.fiap.soat.foodsystem.adapter.service;

import com.fiap.soat.foodsystem.adapter.dto.PedidoDTOReceived;
import com.fiap.soat.foodsystem.adapter.dto.PedidoDTOResponse;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoMapper;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoProdutoMapper;
import com.fiap.soat.foodsystem.domain.model.Cliente;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.model.PedidoProduto;
import com.fiap.soat.foodsystem.domain.ports.ClienteServicePort;
import com.fiap.soat.foodsystem.domain.ports.PedidoServicePort;
import com.fiap.soat.foodsystem.domain.ports.ProdutoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PedidoServiceAdapter {

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private PedidoProdutoMapper pedidoProdutoMapper;

    @Autowired
    private PedidoServicePort pedidoServicePort;

    @Autowired
    private ProdutoServicePort produtoServicePort;

    @Autowired
    private ClienteServicePort clienteServicePort;


    public PedidoDTOResponse salvarPedido(PedidoDTOReceived pedidoDTOReceived) {
        Pedido pedido = this.pedidoMapper.pedidoDTOReceivedToPedido(pedidoDTOReceived);
        if (!Objects.isNull(pedidoDTOReceived.getIdCliente())) {
            Cliente cliente = this.clienteServicePort.obterClientePorId(pedidoDTOReceived.getIdCliente());
            pedido.setCliente(cliente);
        }
        List<PedidoProduto> listaPedidoProduto = pedidoDTOReceived.getListaPedidoProduto().stream().map(pedidoProdutoDTOreceived -> {
            PedidoProduto pedidoProduto = this.pedidoProdutoMapper.pedidoProdutoDTOReceivedTOPedidoProduto(pedidoProdutoDTOreceived);
            pedidoProduto.setProduto(this.produtoServicePort.buscarProdutoPorId(pedidoProdutoDTOreceived.getIdProduto()));
            return pedidoProduto;
        }).toList();
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return this.pedidoMapper.pedidoToPedidoDTOResponse(this.pedidoServicePort.salvarPedido(pedido));
    }

    public PedidoDTOResponse atualizarPedido(PedidoDTOReceived pedidoDTOReceived) {
        Pedido pedido = this.pedidoMapper.pedidoDTOReceivedToPedido(pedidoDTOReceived);
        if (!Objects.isNull(pedidoDTOReceived.getIdCliente())) {
            Cliente cliente = this.clienteServicePort.obterClientePorId(pedidoDTOReceived.getIdCliente());
            pedido.setCliente(cliente);
        }
        List<PedidoProduto> listaPedidoProduto = pedidoDTOReceived.getListaPedidoProduto().stream().map(pedidoProdutoDTOreceived -> {
            PedidoProduto pedidoProduto = this.pedidoProdutoMapper.pedidoProdutoDTOReceivedTOPedidoProduto(pedidoProdutoDTOreceived);
            pedidoProduto.setProduto(this.produtoServicePort.buscarProdutoPorId(pedidoProdutoDTOreceived.getIdProduto()));
            return pedidoProduto;
        }).toList();
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return this.pedidoMapper.pedidoToPedidoDTOResponse(this.pedidoServicePort.atualizarPedido(pedido));
    }
}
