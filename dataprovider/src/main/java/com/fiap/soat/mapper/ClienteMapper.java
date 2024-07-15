package com.fiap.soat.mapper;

import com.fiap.soat.entities.Cliente;
import com.fiap.soat.entities.ClienteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper mapper;

    public Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        return mapper.map(clienteEntity, Cliente.class);
    }

    public ClienteEntity clienteToClienteEntity(Cliente cliente) {
        return mapper.map(cliente, ClienteEntity.class);
    }
}
