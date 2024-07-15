package com.fiap.soat.services;

import com.fiap.soat.entities.Pedido;
import com.fiap.soat.enums.StatusPagamento;
import com.fiap.soat.enums.StatusPedido;
import com.fiap.soat.exceptions.NotFoundException;
import com.fiap.soat.ports.FilaPreparoServicePort;
import com.fiap.soat.ports.PagamentoServicePort;
import com.fiap.soat.ports.PedidoRepositoryPort;
import com.fiap.soat.ports.PedidoServicePort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PedidoService implements PedidoServicePort {

    private PedidoRepositoryPort pedidoRepositoryPort;

    private PagamentoServicePort pagamentoServicePort;

    private FilaPreparoServicePort filaPreparoServicePort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort, PagamentoServicePort pagamentoServicePort, FilaPreparoServicePort filaPreparoServicePort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.pagamentoServicePort = pagamentoServicePort;
        this.filaPreparoServicePort = filaPreparoServicePort;
    }

    @Override
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
    public void cancelarPedido(Long id) {
        Pedido pedido = this.buscarPedidoPorId(id);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        this.pedidoRepositoryPort.cancelarPedido(pedido);
    }

    @Override
    public void confirmarPagamento(Long id) {
        Pedido pedido = this.buscarPedidoPorId(id);
        pedido.setStatusPagamento(StatusPagamento.PAGAMENTO_FINALIZADO);
        pedido.setStatusPedido(StatusPedido.EM_PREPARACAO);
        this.pedidoRepositoryPort.atualizarPedido(pedido);

        this.enviarPedidoParaFilaPreparo(pedido);
    }

    private void enviarPedidoParaFilaPreparo(Pedido pedido) {
        this.filaPreparoServicePort.enviarPedidoParaFilaPreparo(pedido);
    }

}
