package com.fiap.soat.foodsystem.domain.services;

import com.fiap.soat.foodsystem.common.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.enums.StatusPagamento;
import com.fiap.soat.foodsystem.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.ports.PagamentoServicePort;
import com.fiap.soat.foodsystem.domain.ports.PedidoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.PedidoServicePort;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PedidoService implements PedidoServicePort {

    private PedidoRepositoryPort pedidoRepositoryPort;

    private PagamentoServicePort pagamentoServicePort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort, PagamentoServicePort pagamentoServicePort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.pagamentoServicePort = pagamentoServicePort;
    }

    @Override
    @Transactional
    public Pedido salvarPedido(Pedido pedido) {
        pedido.setId(null);
        pedido.setValorTotalPedido(BigDecimal.ZERO);
        pedido.getListaPedidoProdutos().stream().forEach(pedidoProduto -> {
            pedidoProduto.setSubTotal(pedidoProduto.getPrecoUnitario().multiply(BigDecimal.valueOf(pedidoProduto.getQtdeProduto())));
            pedido.setValorTotalPedido(pedido.getValorTotalPedido().add(pedidoProduto.getSubTotal()));
        });
        pedido.setStatusPedido(StatusPedido.RECEBIDO);
        pedido.setStatusPagamento(StatusPagamento.PAGAMENTO_PENDENTE);
        pedido.setDataHoraCriacao(LocalDateTime.now());
        Pedido pedidoSaved = this.pedidoRepositoryPort.criarPedido(pedido);
        pedidoSaved.setqRCode(pagamentoServicePort.solicitarQRCode(pedidoSaved.getId(), pedidoSaved.getValorTotalPedido(), pedidoSaved.getDataHoraCriacao()));
        return pedidoSaved;
    }

    @Override
    public List<Pedido> buscarPedidoPorStatus(Integer status) {
        StatusPedido statusPedido = Arrays.stream(StatusPedido.values()).filter(x -> x.ordinal() == status.intValue()).findFirst()
                .orElseThrow(() -> new NotFoundException("Status inválido"));
        return this.pedidoRepositoryPort.listarPedidoPorStatus(statusPedido);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return this.pedidoRepositoryPort.buscarPedidoPorId(id);
    }

    @Override
    @Transactional
    public Pedido atualizarPedido(Pedido pedido) {
        Pedido pedidoOriginal = this.pedidoRepositoryPort.buscarPedidoPorId(pedido.getId());
        pedido.setValorTotalPedido(BigDecimal.ZERO);
        pedido.getListaPedidoProdutos().stream().forEach(pedidoProduto -> {
            pedidoProduto.setSubTotal(pedidoProduto.getPrecoUnitario().multiply(BigDecimal.valueOf(pedidoProduto.getQtdeProduto())));
            pedido.setValorTotalPedido(pedido.getValorTotalPedido().add(pedidoProduto.getSubTotal()));
        });
        pedido.setStatusPagamento(pedidoOriginal.getStatusPagamento());
        pedido.setStatusPedido(pedidoOriginal.getStatusPedido());
        pedido.setDataHoraCriacao(pedidoOriginal.getDataHoraCriacao());
        return this.pedidoRepositoryPort.atualizarPedido(pedido);
    }

    @Override
    @Transactional
    public void cancelarPedido(Long id) {
        Pedido pedido = this.buscarPedidoPorId(id);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        this.pedidoRepositoryPort.cancelarPedido(pedido);
    }
}
