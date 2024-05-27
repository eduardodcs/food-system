package com.fiap.soat.foodsystem.adapter.infra.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AtualizacaoStatusUtil {
    public void avancarPedido() {
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
