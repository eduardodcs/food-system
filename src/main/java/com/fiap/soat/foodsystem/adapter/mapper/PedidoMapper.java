package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.adapter.dto.ClienteDTO;
import com.fiap.soat.foodsystem.adapter.dto.PedidoDTO;
import com.fiap.soat.foodsystem.adapter.dto.PedidoProdutoDTO;
import com.fiap.soat.foodsystem.adapter.entities.ClienteEntity;
import com.fiap.soat.foodsystem.adapter.entities.PedidoEntity;
import com.fiap.soat.foodsystem.adapter.entities.PedidoProdutoEntity;
import com.fiap.soat.foodsystem.domain.model.Cliente;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.model.PedidoProduto;
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

    public Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteMapper.clienteDTOToCliente(pedidoDTO.getCliente());
        List<PedidoProduto> listaPedidoProduto = pedidoDTO.getListaPedidoProduto().stream()
                .map(pedidoProdutoDTO -> pedidoProdutoMapper.pedidoProdutoDTOToPedidoProduto(pedidoProdutoDTO)).toList();
        Pedido pedido = mapper.map(pedidoDTO, Pedido.class);
        pedido.setCliente(cliente);
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return pedido;
    }

    public PedidoDTO pedidoToPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = mapper.map(pedido, PedidoDTO.class);
        ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(pedido.getCliente());
        List<PedidoProdutoDTO> listaPedidoProdutoDTO = pedido.getListaPedidoProdutos().stream()
                .map(pedidoProduto -> pedidoProdutoMapper.peditoProdutoToPedidoProdutoDTO(pedidoProduto, pedidoDTO)).toList();
        pedidoDTO.setCliente(clienteDTO);
        pedidoDTO.setListaPedidoProduto(listaPedidoProdutoDTO);
        return pedidoDTO;
    }

    public PedidoEntity pedidoToPedidoEntity(Pedido pedido) {
        PedidoEntity pedidoEntity = mapper.map(pedido, PedidoEntity.class);
        ClienteEntity clienteEntity = clienteMapper.clienteToClienteEntity(pedido.getCliente());
        List<PedidoProdutoEntity> listaPedidoProdutoEntity = pedido.getListaPedidoProdutos().stream()
                .map(pedidoProduto -> pedidoProdutoMapper.pedidoProdutoToPedidoProdutoEntity(pedidoProduto, pedidoEntity)).toList();
        pedidoEntity.setCliente(clienteEntity);
        pedidoEntity.setListaPedidoProdutos(listaPedidoProdutoEntity);
        return pedidoEntity;
    }

    public Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        Pedido pedido = mapper.map(pedidoEntity, Pedido.class);
        Cliente cliente = clienteMapper.clienteEntityToCliente(pedidoEntity.getCliente());
        List<PedidoProduto> listaPedidoProduto = pedidoEntity.getListaPedidoProdutos().stream()
                .map(pedidoProdutoEntity -> pedidoProdutoMapper.pedidoProdutoEntityToPedidoProduto(pedidoProdutoEntity, pedido)).toList();

        pedido.setCliente(cliente);
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return pedido;
    }
}
