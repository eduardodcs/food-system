package com.fiap.soat.foodsystem.domain.ports;

import com.fiap.soat.foodsystem.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> buscarPorCpf(String cpf);
    Cliente buscarPorId(Long id);
    String salvar(Cliente cliente);
    boolean atualizar(Cliente cliente);
    boolean excluir(String cpf);
}
