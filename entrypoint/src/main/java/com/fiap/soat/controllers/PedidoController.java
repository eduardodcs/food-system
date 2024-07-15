package com.fiap.soat.controllers;

import com.fiap.soat.dto.PedidoDTOReceived;
import com.fiap.soat.dto.PedidoDTOResponse;
import com.fiap.soat.entities.Pedido;
import com.fiap.soat.presenters.PedidoPresenter;
import com.fiap.soat.ports.usecases.PedidoUseCasePort;
import com.fiap.soat.service.PedidoServiceAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoUseCasePort pedidoUseCasePort;

    @Autowired
    private PedidoServiceAdapter pedidoServiceAdapter;

    @Autowired
    private PedidoPresenter pedidoPresenter;

    @PostMapping
    @Transactional
    @Tag(name = "Pedido")
    @Operation(summary = "Salvar pedido")
    public ResponseEntity<PedidoDTOResponse> salvarPedido(@RequestBody @Valid PedidoDTOReceived pedidoDTOReceived){
        return ResponseEntity.ok(this.pedidoServiceAdapter.salvarPedido(pedidoDTOReceived));
    }

    @GetMapping("{id}")
    @Tag(name = "Pedido")
    @Operation(summary = "Buscar pedido por Id")
    public ResponseEntity<PedidoDTOResponse> buscarPedidoPorId(@PathVariable("id") Long id){
        Pedido pedido = this.pedidoUseCasePort.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedidoPresenter.pedidoToPedidoDTOResponse(pedido));
    }

    @GetMapping("/status/{status}")
    @Tag(name = "Pedido")
    @Operation(summary = "Buscar pedido por status")
    public ResponseEntity<List<PedidoDTOResponse>> buscarPedidosPorStatus(@PathVariable("status") Integer status){
        List<Pedido> listaPedido = this.pedidoUseCasePort.buscarPedidoPorStatus(status);
        return ResponseEntity.ok(listaPedido.stream().map(pedido -> pedidoPresenter.pedidoToPedidoDTOResponse(pedido)).toList());
    }

    @PutMapping
    @Transactional
    @Tag(name = "Pedido")
    @Operation(summary = "Atualizar pedido")
    public ResponseEntity<PedidoDTOResponse> atualizarPedido(@RequestBody @Valid PedidoDTOReceived pedidoDTOReceived){
        return ResponseEntity.ok(this.pedidoServiceAdapter.atualizarPedido(pedidoDTOReceived));
    }


    @PutMapping("{id}")
    @Transactional
    @Tag(name = "Pedido")
    @Operation(summary = "Cancelar pedido")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarPedido(@PathVariable("id") Long id){
        this.pedidoUseCasePort.cancelarPedido(id);
    }

}
