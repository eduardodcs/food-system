package com.fiap.soat.foodsystem.adapter.infra.repository;

import com.fiap.soat.foodsystem.adapter.entities.PedidoEntity;
import com.fiap.soat.foodsystem.adapter.infra.utils.AtualizacaoStatusUtil;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoMapper;
import com.fiap.soat.foodsystem.common.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.ports.PedidoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        PedidoEntity pedido1 = pedidoMapper.pedidoToPedidoEntity(pedido);
        PedidoEntity pedidoEntity = this.pedidoRepository.save(pedido1);
        return pedidoMapper.pedidoEntityToPedido(pedidoEntity);
    }

    @Override
    public List<Pedido> listarPedidoPorStatus(StatusPedido statusPedido) {
        List<PedidoEntity> listaPedidoEntity = this.pedidoRepository.findByStatusPedido(statusPedido);
        return listaPedidoEntity.stream().map(pedidoEntity -> pedidoMapper.pedidoEntityToPedido(pedidoEntity)).toList();
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        PedidoEntity pedidoEntity = this.pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado com o ID informado."));
        return pedidoMapper.pedidoEntityToPedido(pedidoEntity);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoRepository.save(pedidoMapper.pedidoToPedidoEntity(pedido));
        return pedidoMapper.pedidoEntityToPedido(pedidoEntity);
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        pedidoRepository.save(pedidoMapper.pedidoToPedidoEntity(pedido));
    }
}
