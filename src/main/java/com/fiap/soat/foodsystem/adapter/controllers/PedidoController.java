package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.dto.PedidoDTO;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoMapper;
import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.ports.PedidoServicePort;
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
    private PedidoServicePort pedidoServicePort;

    @Autowired
    private PedidoMapper pedidoMapper;

    @PostMapping
    @Transactional
    @Tag(name = "Pedido")
    @Operation(summary = "Salvar pedido")
    public ResponseEntity<PedidoDTO> salvarPedido(@RequestBody @Valid PedidoDTO pedidoDTO){
        Pedido pedido = this.pedidoServicePort.salvarPedido(this.pedidoMapper.pedidoDTOToPedido(pedidoDTO));
        return ResponseEntity.ok(pedidoMapper.pedidoToPedidoDTO(pedido));
    }

    @GetMapping("{id}")
    @Tag(name = "Pedido")
    @Operation(summary = "Buscar pedido por Id")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable("id") Long id){
        Pedido pedido = this.pedidoServicePort.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedidoMapper.pedidoToPedidoDTO(pedido));
    }

    @GetMapping("/status/{status}")
    @Tag(name = "Pedido")
    @Operation(summary = "Buscar pedido por status")
    public ResponseEntity<List<PedidoDTO>> buscarPedidosPorStatus(@PathVariable("status") Integer status){
        List<Pedido> listaPedido = this.pedidoServicePort.buscarPedidoPorStatus(status);
        return ResponseEntity.ok(listaPedido.stream().map(pedido -> pedidoMapper.pedidoToPedidoDTO(pedido)).toList());
    }

    @PutMapping
    @Transactional
    @Tag(name = "Pedido")
    @Operation(summary = "Atualizar pedido")
    public ResponseEntity<PedidoDTO> atualizarPedido(@RequestBody @Valid PedidoDTO pedidoDTO){
        Pedido pedido = this.pedidoServicePort.atualizarPedido(this.pedidoMapper.pedidoDTOToPedido(pedidoDTO));
        return ResponseEntity.ok(pedidoMapper.pedidoToPedidoDTO(pedido));
    }


    @PutMapping("{id}")
    @Transactional
    @Tag(name = "Pedido")
    @Operation(summary = "Cancelar pedido")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarPedido(@PathVariable("id") Long id){
        this.pedidoServicePort.cancelarPedido(id);
    }

}
