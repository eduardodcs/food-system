package com.fiap.soat.foodsystem.application.shared.utils;

import com.fiap.soat.foodsystem.adapter.pedido.PedidoServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AtualizacaoStatusUtil {

    @Autowired
    private PedidoServiceAdapter pedidoServiceAdapter;

    public void avancarPedido(Long id) {
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
                        // Contorno para não cair me ciclo de dependência
//                        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
//                        PedidoServiceAdapter pedidoServiceAdapter = context.getBean(PedidoServiceAdapter.class);
//                        pedidoServiceAdapter.confirmarPagamento(id);
                        this.pedidoServiceAdapter.confirmarPagamento(id);
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
