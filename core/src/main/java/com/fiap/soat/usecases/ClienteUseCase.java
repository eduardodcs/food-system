package com.fiap.soat.usecases;

import com.fiap.soat.entities.Cliente;
import com.fiap.soat.exceptions.DomainException;
import com.fiap.soat.ports.gateways.ClienteGatewayPort;
import com.fiap.soat.ports.usecases.ClienteUseCasePort;

import java.util.Optional;

public class ClienteUseCase implements ClienteUseCasePort {

    private final ClienteGatewayPort repositoryPort;

    public ClienteUseCase(ClienteGatewayPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Cliente consultarClientePorCpf(String cpf){
        Optional<Cliente> cliente = repositoryPort.buscarPorCpf(cpf);
        return cliente.orElse(null);
    }

    @Override
    public Optional<Cliente> cadastrar(Cliente cliente) {
        try {
            String retorno = repositoryPort.salvar(cliente);
            if (retorno.isEmpty() || retorno.contains("|")) {
                return Optional.empty();
            } else {
                cliente.setId(Long.parseLong(retorno));
                return Optional.of(cliente);
            }
        } catch (Exception ex) {
            throw new DomainException("Não foi possível salvar o cliente", ex.getCause());
        }
    }

    @Override
    public Optional<Cliente> atualizarDados(Cliente cliente) {
        Optional<Boolean> clienteAtualizado = Optional.of(repositoryPort.atualizar(cliente));
        if (clienteAtualizado.get()){
            return Optional.of(cliente);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> excluir(String cpf) {
        return Optional.of(repositoryPort.excluir(cpf));
    }

    @Override
    public Cliente obterClientePorId(Long id) {
        return this.repositoryPort.buscarPorId(id);
    }

}
