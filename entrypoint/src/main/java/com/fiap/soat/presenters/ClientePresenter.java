package com.fiap.soat.mapper;

import com.fiap.soat.dto.ClienteDTO;
import com.fiap.soat.entities.Cliente;
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

}
