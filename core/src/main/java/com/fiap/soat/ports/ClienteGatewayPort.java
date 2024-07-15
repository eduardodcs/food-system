package com.fiap.soat.ports;

import com.fiap.soat.entities.Cliente;

import java.util.Optional;

public interface ClienteGatewayPort {
    Optional<Cliente> buscarPorCpf(String cpf);
    Cliente buscarPorId(Long id);
    String salvar(Cliente cliente);
    boolean atualizar(Cliente cliente);
    boolean excluir(String cpf);
}
