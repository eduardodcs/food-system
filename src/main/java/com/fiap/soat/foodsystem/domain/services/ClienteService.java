package com.fiap.soat.foodsystem.domain.services;

import com.fiap.soat.foodsystem.domain.Cliente;
import com.fiap.soat.foodsystem.domain.ports.ClienteRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.ClienteServicePort;

import java.util.Optional;

public class ClienteService implements ClienteServicePort {

    private final ClienteRepositoryPort repositoryPort;

    public ClienteService(ClienteRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Cliente consultarClientePorCpf(String cpf){
        Optional<Cliente> cliente = repositoryPort.buscarPorCpf(cpf);
        return cliente.orElse(null);
    }

    @Override
    public Cliente consultarClientePorNome(String nome) {
        return null;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        System.out.println("Teste");
    }

    @Override
    public void atualizarDados(Cliente cliente) {
        System.out.println("Teste");
    }

    @Override
    public void excluir(String cpf) {
        System.out.println("Teste");
    }

}
