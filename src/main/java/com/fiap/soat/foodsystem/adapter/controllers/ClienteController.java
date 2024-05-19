package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.ClienteDTO;
import com.fiap.soat.foodsystem.domain.Cliente;
import com.fiap.soat.foodsystem.domain.ports.ClienteServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteServicePort servicePort;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public ClienteController(ClienteServicePort service) {
        this.servicePort = service;
    }

    @GetMapping("/{cpf}")
    @Tag(name = "Cliente")
    @Operation(summary = "Buscar Cliente pelo CPF")
    public ResponseEntity<ClienteDTO> buscarClientePorCpf(@Valid @PathVariable String cpf) {
        Optional<Cliente> optionalCliente = Optional.ofNullable(servicePort.consultarClientePorCpf(cpf));

        return optionalCliente.map(cliente -> ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class))).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
