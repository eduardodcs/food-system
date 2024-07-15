package com.fiap.soat.ports;

import com.fiap.soat.entities.Cliente;

import java.util.Optional;

public interface ClienteUseCasePort {
    Cliente consultarClientePorCpf(String cpf);

    Optional<Cliente> cadastrar(Cliente cliente);

    Optional<Cliente> atualizarDados(Cliente cliente);

    Optional<Boolean> excluir(String cpf);

    Cliente obterClientePorId(Long id);
}