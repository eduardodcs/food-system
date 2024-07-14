package com.fiap.soat.foodsystem.adapter.interfaces;

import com.fiap.soat.foodsystem.modules.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> buscarPorCpf(String cpf);
    Cliente buscarPorId(Long id);
    String salvar(Cliente cliente);
    boolean atualizar(Cliente cliente);
    boolean excluir(String cpf);
}
