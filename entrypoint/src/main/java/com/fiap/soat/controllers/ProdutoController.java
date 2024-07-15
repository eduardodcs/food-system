package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTOReceived;
import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTOResponse;
import com.fiap.soat.foodsystem.adapter.mapper.ProdutoMapper;
import com.fiap.soat.foodsystem.adapter.service.ProdutoServiceAdapter;
import com.fiap.soat.foodsystem.domain.model.Produto;
import com.fiap.soat.foodsystem.domain.ports.ProdutoServicePort;
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
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoServicePort produtoServicePort;

    @Autowired
    private ProdutoServiceAdapter produtoServiceAdapter;

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping("categoria/{categoriaId}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar lista de produtos disponíveis por categoria")
    public ResponseEntity<List<ProdutoDTOResponse>> buscarProdutosPorCategoria(@PathVariable Long categoriaId) {
        List<Produto> listaProduto = this.produtoServicePort.buscarProdutosPorCategoria(categoriaId);
        return ResponseEntity.ok(listaProduto.stream().map(produto -> produtoMapper.produtoToProdutoDTOResponse(produto)).toList());
    }

    @GetMapping("{id}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar produto por Id")
    public ResponseEntity<ProdutoDTOResponse> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = this.produtoServicePort.buscarProdutoPorId(id);
        return ResponseEntity.ok(produtoMapper.produtoToProdutoDTOResponse(produto));
    }

    @PutMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Editar cadastro de produto")
    public ResponseEntity<ProdutoDTOResponse> editarProduto(@Valid @RequestBody ProdutoDTOReceived produtoDTOReceived) {
        return ResponseEntity.ok(this.produtoServiceAdapter.editarProduto(produtoDTOReceived));
    }

    @PostMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Cadastrar produto")
    public ResponseEntity<ProdutoDTOResponse> cadastrarProduto(@Valid @RequestBody ProdutoDTOReceived produtoDTOReceived) {
        return ResponseEntity.ok(this.produtoServiceAdapter.cadastrarProduto(produtoDTOReceived));
    }

    @PutMapping("/inativar/{id}")
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Ativar / Inativar produto")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void inativarProduto(@PathVariable Long id) {
        this.produtoServicePort.inativarProduto(id);
    }

}
