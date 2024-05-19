package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.Cliente;

import java.util.Optional;

public interface ClienteServicePort {
    Cliente consultarClientePorCpf(String cpf);

    Cliente cadastrar(Cliente cliente);

    Optional<Cliente> atualizarDados(Cliente cliente);

    Optional<Boolean> excluir(String cpf);
}