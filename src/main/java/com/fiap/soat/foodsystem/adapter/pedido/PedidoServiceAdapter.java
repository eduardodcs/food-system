package com.fiap.soat.foodsystem.adapter.pedido;

import com.fiap.soat.foodsystem.modules.dto.PedidoDTOReceived;
import com.fiap.soat.foodsystem.modules.dto.PedidoDTOResponse;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoMapper;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoProdutoMapper;
import com.fiap.soat.foodsystem.modules.domain.model.Cliente;
import com.fiap.soat.foodsystem.modules.domain.model.Pedido;
import com.fiap.soat.foodsystem.modules.domain.model.PedidoProduto;
import com.fiap.soat.foodsystem.adapter.interfaces.ClienteServicePort;
import com.fiap.soat.foodsystem.adapter.interfaces.PedidoServicePort;
import com.fiap.soat.foodsystem.adapter.interfaces.ProdutoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
        Pedido pedidoSalvo = this.pedidoServicePort.salvarPedido(pedido);
        this.fakeCallbackPagamento(pedidoSalvo.getId());
        return this.pedidoMapper.pedidoToPedidoDTOResponse(pedidoSalvo);
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

    public void confirmarPagamento(Long id) {
        this.pedidoServicePort.confirmarPagamento(id);
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
                        this.pedidoServicePort.confirmarPagamento(id);
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
