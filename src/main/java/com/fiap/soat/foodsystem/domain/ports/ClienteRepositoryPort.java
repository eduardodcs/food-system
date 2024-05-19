package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> buscarPorCpf(String cpf);
    Optional<Cliente> buscarPorNome(String nome);
    void salvar(Cliente cliente);
    void atualizar(Cliente cliente);
    void excluir(String cpf);
}
