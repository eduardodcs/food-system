package com.fiap.soat.foodsystem.adapter.controllers;

import com.fiap.soat.foodsystem.adapter.dto.CategoriaDTO;
import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.ports.CategoriaServicePort;
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
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServicePort categoriaServicePort;

    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    @Tag(name = "Categoria")
    @Operation(summary = "Buscar lista de categorias disponíveis")
    public ResponseEntity<List<CategoriaDTO>> buscarCategorias() {
        List<Categoria> listaCategoria = this.categoriaServicePort.buscarCategorias();
        return ResponseEntity.ok(listaCategoria.stream().map(categoria -> this.mapper.map(categoria, CategoriaDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    @Tag(name = "Categoria")
    @Operation(summary = "Buscar categoria por Id")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) {
        Categoria categoria = this.categoriaServicePort.buscarCategoriaPorId(id);
        return ResponseEntity.ok(this.mapper.map(categoria, CategoriaDTO.class));
    }

    @PutMapping
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Editar cadastro de categoria")
    public ResponseEntity<CategoriaDTO> editarCategoria(@Valid @RequestBody CategoriaDTO categoriaFTO) {
        Categoria categoria = this.categoriaServicePort.editarCategoria(this.mapper.map(categoriaFTO, Categoria.class));
        return ResponseEntity.ok(this.mapper.map(categoria, CategoriaDTO.class));
    }

    @PostMapping
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Cadastrar categoria")
    public ResponseEntity<CategoriaDTO> cadatrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = this.categoriaServicePort.salvarCategoria(this.mapper.map(categoriaDTO, Categoria.class));
        return ResponseEntity.ok(this.mapper.map(categoria, CategoriaDTO.class));
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
