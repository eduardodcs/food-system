package com.fiap.soat.usecases;

import com.fiap.soat.entities.Pedido;
import com.fiap.soat.enums.StatusPagamento;
import com.fiap.soat.enums.StatusPedido;
import com.fiap.soat.exceptions.NotFoundException;
import com.fiap.soat.ports.usecases.FilaPreparoUseCasePort;
import com.fiap.soat.ports.usecases.PagamentoUseCasePort;
import com.fiap.soat.ports.gateways.PedidoGatewayPort;
import com.fiap.soat.ports.usecases.PedidoUseCasePort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PedidoUseCase implements PedidoUseCasePort {

    private PedidoGatewayPort pedidoGatewayPort;

    private PagamentoUseCasePort pagamentoUseCasePort;

    private FilaPreparoUseCasePort filaPreparoUseCasePort;

    public PedidoUseCase(PedidoGatewayPort pedidoGatewayPort, PagamentoUseCasePort pagamentoUseCasePort, FilaPreparoUseCasePort filaPreparoUseCasePort) {
        this.pedidoGatewayPort = pedidoGatewayPort;
        this.pagamentoUseCasePort = pagamentoUseCasePort;
        this.filaPreparoUseCasePort = filaPreparoUseCasePort;
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
        Pedido pedidoSaved = this.pedidoGatewayPort.criarPedido(pedido);
        pedidoSaved.setqRCode(pagamentoUseCasePort.solicitarQRCode(pedidoSaved.getId(), pedidoSaved.getValorTotalPedido(), pedidoSaved.getDataHoraCriacao()));
        return pedidoSaved;
    }

    @Override
    public List<Pedido> buscarPedidoPorStatus(Integer status) {
        StatusPedido statusPedido = Arrays.stream(StatusPedido.values()).filter(x -> x.ordinal() == status.intValue()).findFirst()
                .orElseThrow(() -> new NotFoundException("Status inválido"));
        return this.pedidoGatewayPort.listarPedidoPorStatus(statusPedido);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return this.pedidoGatewayPort.buscarPedidoPorId(id);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        Pedido pedidoOriginal = this.pedidoGatewayPort.buscarPedidoPorId(pedido.getId());
        pedido.setValorTotalPedido(BigDecimal.ZERO);
        pedido.getListaPedidoProdutos().stream().forEach(pedidoProduto -> {
            pedidoProduto.setSubTotal(pedidoProduto.getPrecoUnitario().multiply(BigDecimal.valueOf(pedidoProduto.getQtdeProduto())));
            pedido.setValorTotalPedido(pedido.getValorTotalPedido().add(pedidoProduto.getSubTotal()));
        });
        pedido.setStatusPagamento(pedidoOriginal.getStatusPagamento());
        pedido.setStatusPedido(pedidoOriginal.getStatusPedido());
        pedido.setDataHoraCriacao(pedidoOriginal.getDataHoraCriacao());
        return this.pedidoGatewayPort.atualizarPedido(pedido);
    }

    @Override
    public void cancelarPedido(Long id) {
        Pedido pedido = this.buscarPedidoPorId(id);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        this.pedidoGatewayPort.cancelarPedido(pedido);
    }

    @Override
    public void confirmarPagamento(Long id) {
        Pedido pedido = this.buscarPedidoPorId(id);
        pedido.setStatusPagamento(StatusPagamento.PAGAMENTO_FINALIZADO);
        pedido.setStatusPedido(StatusPedido.EM_PREPARACAO);
        this.pedidoGatewayPort.atualizarPedido(pedido);

        this.enviarPedidoParaFilaPreparo(pedido);
    }

    private void enviarPedidoParaFilaPreparo(Pedido pedido) {
        this.filaPreparoUseCasePort.enviarPedidoParaFilaPreparo(pedido);
    }

}
