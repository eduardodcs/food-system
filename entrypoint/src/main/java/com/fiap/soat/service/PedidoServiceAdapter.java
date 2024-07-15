package com.fiap.soat.service;

import com.fiap.soat.dto.PedidoDTOReceived;
import com.fiap.soat.dto.PedidoDTOResponse;

import com.fiap.soat.entities.Cliente;
import com.fiap.soat.entities.Pedido;
import com.fiap.soat.entities.PedidoProduto;
import com.fiap.soat.presenters.PedidoPresenter;
import com.fiap.soat.presenters.PedidoProdutoPresenter;
import com.fiap.soat.ports.ClienteUseCasePort;
import com.fiap.soat.ports.PedidoUseCasePort;
import com.fiap.soat.ports.ProdutoUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoServiceAdapter {

    @Autowired
    private PedidoPresenter pedidoPresenter;

    @Autowired
    private PedidoProdutoPresenter pedidoProdutoPresenter;

    @Autowired
    private PedidoUseCasePort pedidoUseCasePort;

    @Autowired
    private ProdutoUseCasePort produtoUseCasePort;

    @Autowired
    private ClienteUseCasePort clienteUseCasePort;

    public PedidoDTOResponse salvarPedido(PedidoDTOReceived pedidoDTOReceived) {
        Pedido pedido = this.pedidoPresenter.pedidoDTOReceivedToPedido(pedidoDTOReceived);
        if (!Objects.isNull(pedidoDTOReceived.getIdCliente())) {
            Cliente cliente = this.clienteUseCasePort.obterClientePorId(pedidoDTOReceived.getIdCliente());
            pedido.setCliente(cliente);
        }
        List<PedidoProduto> listaPedidoProduto = pedidoDTOReceived.getListaPedidoProduto().stream().map(pedidoProdutoDTOreceived -> {
            PedidoProduto pedidoProduto = this.pedidoProdutoPresenter.pedidoProdutoDTOReceivedTOPedidoProduto(pedidoProdutoDTOreceived);
            pedidoProduto.setProduto(this.produtoUseCasePort.buscarProdutoPorId(pedidoProdutoDTOreceived.getIdProduto()));
            return pedidoProduto;
        }).toList();
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        Pedido pedidoSalvo = this.pedidoUseCasePort.salvarPedido(pedido);
        this.fakeCallbackPagamento(pedidoSalvo.getId());
        return this.pedidoPresenter.pedidoToPedidoDTOResponse(pedidoSalvo);
    }

    public PedidoDTOResponse atualizarPedido(PedidoDTOReceived pedidoDTOReceived) {
        Pedido pedido = this.pedidoPresenter.pedidoDTOReceivedToPedido(pedidoDTOReceived);
        if (!Objects.isNull(pedidoDTOReceived.getIdCliente())) {
            Cliente cliente = this.clienteUseCasePort.obterClientePorId(pedidoDTOReceived.getIdCliente());
            pedido.setCliente(cliente);
        }
        List<PedidoProduto> listaPedidoProduto = pedidoDTOReceived.getListaPedidoProduto().stream().map(pedidoProdutoDTOreceived -> {
            PedidoProduto pedidoProduto = this.pedidoProdutoPresenter.pedidoProdutoDTOReceivedTOPedidoProduto(pedidoProdutoDTOreceived);
            pedidoProduto.setProduto(this.produtoUseCasePort.buscarProdutoPorId(pedidoProdutoDTOreceived.getIdProduto()));
            return pedidoProduto;
        }).toList();
        pedido.setListaPedidoProdutos(listaPedidoProduto);
        return this.pedidoPresenter.pedidoToPedidoDTOResponse(this.pedidoUseCasePort.atualizarPedido(pedido));
    }

    public void confirmarPagamento(Long id) {
        this.pedidoUseCasePort.confirmarPagamento(id);
    }


    public void fakeCallbackPagamento(Long id) {
        CompletableFuture.runAsync(() -> {
            // Utilizando um inteiro só para fazer a count das vezes que vai executar, estimulando o sleep
            int codigo = 1;
            while (true) {

                try {
                    System.out.println("RODANDO MOMENTO "+codigo);
                    // Espera 3 segundos
                    Thread.sleep(3000);

                    //TODO Aqui é necessário atualizar o status conforme algum ENUM correspondente
                    codigo++;
                    if (codigo == 3) {
                        this.pedidoUseCasePort.confirmarPagamento(id);
                        return;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
    }


}
