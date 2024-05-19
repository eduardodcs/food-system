package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.Cliente;

public interface ClienteServicePort {
    Cliente consultarClientePorCpf(String cpf);

    Cliente consultarClientePorNome(String nome);

    void cadastrar(Cliente cliente);

    void atualizarDados(Cliente cliente);

    void excluir(String cpf);
}