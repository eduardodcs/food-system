package com.fiap.soat.foodsystem.adapter.infra.repository;

import com.fiap.soat.foodsystem.adapter.entities.ClienteEntity;
import com.fiap.soat.foodsystem.domain.model.Cliente;
import com.fiap.soat.foodsystem.domain.ports.ClienteRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf) {
        if (localizarCliente(cpf).isPresent()) {
            if (localizarCliente(cpf).get().isFlagAtivo()) {
                return localizarCliente(cpf).map(clienteEntity -> mapper.map(clienteEntity, Cliente.class));
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public String salvar(Cliente cliente) {
        List<String> retorno = new ArrayList<>();
        ClienteEntity entity = mapper.map(cliente, ClienteEntity.class);
        entity.setFlagAtivo(true);
        if (this.clienteRepository.existsByEmail(cliente.getEmail())){
            retorno.add("E-mail já existente na base!");
        }
        if (this.clienteRepository.existsByCpf(cliente.getCpf())) {
            retorno.add("CPF já existente na base!");
        }

        if (retorno.isEmpty()) {
            this.clienteRepository.save(entity);
            return "";
        }
        return String.join("|", retorno);
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        boolean atualizou = false;
        if (localizarCliente(cliente.getCpf()).isPresent()) {
            ClienteEntity entity = mapper.map(cliente, ClienteEntity.class);
            entity.setFlagAtivo(true);
            this.clienteRepository.save(entity);
            atualizou = true;
        }
        return atualizou;
    }

    @Override
    public boolean excluir(String cpf) {
        boolean exclusaoRealizada = false;
        // Se encontrado, realizar exclusão lógica
        if (localizarCliente(cpf).isPresent()) {
            localizarCliente(cpf).get().setFlagAtivo(false);
            this.clienteRepository.save(localizarCliente(cpf).get());
            exclusaoRealizada = true;
        }

        return exclusaoRealizada;
    }

    private Optional<ClienteEntity> localizarCliente(String cpf) {
        return this.clienteRepository.findByCpf(cpf);
    }

}
