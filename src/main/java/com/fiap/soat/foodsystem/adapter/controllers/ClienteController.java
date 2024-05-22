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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteServicePort servicePort;
    private final ModelMapper mapper;

    @Autowired
    public ClienteController(ClienteServicePort service, ModelMapper mapper) {
        this.servicePort = service;
        this.mapper = mapper;
    }

    @GetMapping("/{cpf}")
    @Tag(name = "Cliente")
    @Operation(summary = "Buscar Cliente pelo CPF")
    public ResponseEntity<ClienteDTO> buscarClientePorCpf(@Valid @PathVariable String cpf) {
        Optional<Cliente> optionalCliente = Optional.ofNullable(servicePort.consultarClientePorCpf(cpf));
        return optionalCliente.map(cliente -> ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Tag(name = "Cliente")
    @Operation(summary = "Cadastrar Cliente")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@Validated @RequestBody ClienteDTO dto) {
        Optional<Cliente> response = servicePort.cadastrar(mapper.map(dto, Cliente.class));
        return response.map(cliente -> {
            ClienteDTO mapCliente = mapper.map(cliente, ClienteDTO.class);
            URI uri = URI.create("/cliente");
            return ResponseEntity.created(uri).body(mapCliente);
        }).orElseGet(() -> ResponseEntity.unprocessableEntity().build());
   }

    @PutMapping
    @Tag(name = "Cliente")
    @Operation(summary = "Atualizar dados de Cliente")
    public ResponseEntity<ClienteDTO> atualizarDadosCliente(@Validated @RequestBody ClienteDTO dto) {
        Optional<Cliente> response = servicePort.atualizarDados(mapper.map(dto, Cliente.class));
        return response.map(cliente -> ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cpf}")
    @Tag(name = "Cliente")
    @Operation(summary = "Excluir cadastro do Cliente")
    public ResponseEntity<Boolean> excluirCliente(@Valid @PathVariable String cpf) {
        Optional<Boolean> exclusaoComSucesso = servicePort.excluir(cpf);
        return exclusaoComSucesso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
