package com.fiap.soat.foodsystem.adapter.repository;

import com.fiap.soat.foodsystem.adapter.entities.ClienteEntity;
import com.fiap.soat.foodsystem.domain.Cliente;
import com.fiap.soat.foodsystem.domain.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.ports.ClienteRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf) {
        Optional<ClienteEntity> entity = this.clienteRepository.findById(cpf);
        return entity.map(clienteEntity -> mapper.map(clienteEntity, Cliente.class));
    }

    @Override
    public Optional<Cliente> buscarPorNome(String nome) {
        return Optional.empty();
    }

    @Override
    public void salvar(Cliente cliente) {

    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public void excluir(String cpf) {

    }
}
