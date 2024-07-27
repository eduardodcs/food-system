package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.dto.CategoriaDTO;
import com.fiap.soat.foodsystem.adapter.mapper.CategoriaMapper;
import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.ports.CategoriaServicePort;
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
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServicePort categoriaServicePort;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping()
    @Tag(name = "Categoria")
    @Operation(summary = "Buscar lista de categorias disponíveis")
    public ResponseEntity<List<CategoriaDTO>> buscarCategorias() {
        List<Categoria> listaCategoria = this.categoriaServicePort.buscarCategorias();
        return ResponseEntity.ok(listaCategoria.stream().map(categoria -> categoriaMapper.categoriaToCategoriaDTO(categoria)).toList());
    }

    @GetMapping("{id}")
    @Tag(name = "Categoria")
    @Operation(summary = "Buscar categoria por Id")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) {
        Categoria categoria = this.categoriaServicePort.buscarCategoriaPorId(id);
        return ResponseEntity.ok(categoriaMapper.categoriaToCategoriaDTO(categoria));
    }

    @PutMapping
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Editar cadastro de categoria")
    public ResponseEntity<CategoriaDTO> editarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = this.categoriaServicePort.editarCategoria(categoriaMapper.categoriaDTOToCategoria(categoriaDTO));
        return ResponseEntity.ok(categoriaMapper.categoriaToCategoriaDTO(categoria));
    }

    @PostMapping
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Cadastrar categoria")
    public ResponseEntity<CategoriaDTO> cadatrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = this.categoriaServicePort.salvarCategoria(categoriaMapper.categoriaDTOToCategoria(categoriaDTO));
        return ResponseEntity.ok(categoriaMapper.categoriaToCategoriaDTO(categoria));
    }


    @PutMapping("/inativar/{id}")
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Ativar / Inativar categoria")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void inativarCategoria(@PathVariable Long id) {
        this.categoriaServicePort.inativarCategoria(id);
    }

}
