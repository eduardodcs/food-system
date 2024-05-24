package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.adapter.dto.ClienteDTO;
import com.fiap.soat.foodsystem.adapter.entities.ClienteEntity;
import com.fiap.soat.foodsystem.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper mapper;

    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
        return mapper.map(clienteDTO, Cliente.class);
    }

    public ClienteDTO clienteToClienteDTO(Cliente cliente) {
        return mapper.map(cliente, ClienteDTO.class);
    }

    public Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        return mapper.map(clienteEntity, Cliente.class);
    }

    public ClienteEntity clienteToClienteEntity(Cliente cliente) {
        return mapper.map(cliente, ClienteEntity.class);
    }
}
