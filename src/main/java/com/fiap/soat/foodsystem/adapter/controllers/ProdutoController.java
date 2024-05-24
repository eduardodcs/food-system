package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTO;
import com.fiap.soat.foodsystem.adapter.mapper.ProdutoMapper;
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
    private ProdutoMapper produtoMapper;

    @GetMapping("categoria/{categoriaId}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar lista de produtos disponíveis por categoria")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutosPorCategoria(@PathVariable Long categoriaId) {
        List<Produto> listaProduto = this.produtoServicePort.buscarProdutosPorCategoria(categoriaId);
        return ResponseEntity.ok(listaProduto.stream().map(produto -> produtoMapper.produtoToProdutoDTO(produto)).toList());
    }

    @GetMapping("{id}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar produto por Id")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = this.produtoServicePort.buscarProdutoPorId(id);
        return ResponseEntity.ok(produtoMapper.produtoToProdutoDTO(produto));
    }

    @PutMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Editar cadastro de produto")
    public ResponseEntity<ProdutoDTO> editarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = this.produtoServicePort.editarProduto(produtoMapper.produtoDTOToProduto(produtoDTO));
        return ResponseEntity.ok(produtoMapper.produtoToProdutoDTO(produto));
    }

    @PostMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Cadastrar produto")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto= this.produtoServicePort.salvarProduto(produtoMapper.produtoDTOToProduto(produtoDTO));
        return ResponseEntity.ok(produtoMapper.produtoToProdutoDTO(produto));
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
