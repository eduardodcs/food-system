package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> buscarPorCpf(String cpf);
    String salvar(Cliente cliente);
    boolean atualizar(Cliente cliente);
    boolean excluir(String cpf);
}
