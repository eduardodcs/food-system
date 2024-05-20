package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.dto.CategoriaDTO;
import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTO;
import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.model.Produto;
import com.fiap.soat.foodsystem.domain.ports.ProdutoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoServicePort produtoServicePort;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("categoria/{categoriaId}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar lista de produtos disponíveis por categoria")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutosPorCategoria(@PathVariable Long categoriaId) {
        List<Produto> listaProduto = this.produtoServicePort.buscarProdutosPorCategoria(categoriaId);
        return ResponseEntity.ok(listaProduto.stream().map(produto -> {
            CategoriaDTO categoriaDTO = this.mapper.map(produto.getCategoria(), CategoriaDTO.class);
            ProdutoDTO produtoDTO = this.mapper.map(produto, ProdutoDTO.class);
            produtoDTO.setCategoriaDTO(categoriaDTO);
            return produtoDTO;
        }).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Tag(name = "Produto")
    @Operation(summary = "Buscar produto por Id")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = this.produtoServicePort.buscarProdutoPorId(id);
        ProdutoDTO produtoDTO = this.mapper.map(produto, ProdutoDTO.class);
        CategoriaDTO categoriaDTO = this.mapper.map(produto.getCategoria(), CategoriaDTO.class);
        produtoDTO.setCategoriaDTO(categoriaDTO);
        return ResponseEntity.ok(produtoDTO);
    }

    @PutMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Editar cadastro de produto")
    public ResponseEntity<ProdutoDTO> editarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = this.mapper.map(produtoDTO, Produto.class);
        Categoria categoria = this.mapper.map(produto.getCategoria(), Categoria.class);
        produto.setCategoria(categoria);
        Produto produtoEdited = this.produtoServicePort.editarProduto(produto);
        ProdutoDTO produtoDTOEdited = this.mapper.map(produto, ProdutoDTO.class);
        CategoriaDTO categoriaDTO = this.mapper.map(produtoEdited.getCategoria(), CategoriaDTO.class);
        produtoDTOEdited.setCategoriaDTO(categoriaDTO);
        return ResponseEntity.ok(produtoDTOEdited);
    }

    @PostMapping
    @Transactional
    @Tag(name = "Produto")
    @Operation(summary = "Cadastrar produto")
    public ResponseEntity<ProdutoDTO> cadatrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = this.mapper.map(produtoDTO, Produto.class);
        Categoria categoria = this.mapper.map(produto.getCategoria(), Categoria.class);
        produto.setCategoria(categoria);

        Produto produtoSaved = this.produtoServicePort.salvarProduto(this.mapper.map(produtoDTO, Produto.class));
        ProdutoDTO produtoDTOSaved = this.mapper.map(produtoSaved, ProdutoDTO.class);
        CategoriaDTO categoriaDTO = this.mapper.map(produtoSaved.getCategoria(), CategoriaDTO.class);
        produtoDTOSaved.setCategoriaDTO(categoriaDTO);

        return ResponseEntity.ok(produtoDTOSaved);
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
