package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.modules.dto.ClienteDTO;
import com.fiap.soat.foodsystem.modules.dto.PedidoDTOReceived;
import com.fiap.soat.foodsystem.modules.dto.PedidoDTOResponse;
import com.fiap.soat.foodsystem.modules.dto.PedidoProdutoDTOResponse;
import com.fiap.soat.foodsystem.modules.domain.entities.ClienteEntity;
import com.fiap.soat.foodsystem.modules.domain.entities.PedidoEntity;
import com.fiap.soat.foodsystem.modules.domain.entities.PedidoProdutoEntity;
import com.fiap.soat.foodsystem.modules.domain.model.Cliente;
import com.fiap.soat.foodsystem.modules.domain.model.Pedido;
import com.fiap.soat.foodsystem.modules.domain.model.PedidoProduto;
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
