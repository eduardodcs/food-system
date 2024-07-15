package com.fiap.soat.controllers;

import com.fiap.soat.dto.CategoriaDTO;
import com.fiap.soat.entities.Categoria;
import com.fiap.soat.presenters.CategoriaPresenter;
import com.fiap.soat.ports.CategoriaUseCasePort;
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
    private CategoriaUseCasePort categoriaUseCasePort;

    @Autowired
    private CategoriaPresenter categoriaPresenter;

    @GetMapping()
    @Tag(name = "Categoria")
    @Operation(summary = "Buscar lista de categorias disponíveis")
    public ResponseEntity<List<CategoriaDTO>> buscarCategorias() {
        List<Categoria> listaCategoria = this.categoriaUseCasePort.buscarCategorias();
        return ResponseEntity.ok(listaCategoria.stream().map(categoria -> categoriaPresenter.categoriaToCategoriaDTO(categoria)).toList());
    }

    @GetMapping("{id}")
    @Tag(name = "Categoria")
    @Operation(summary = "Buscar categoria por Id")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) {
        Categoria categoria = this.categoriaUseCasePort.buscarCategoriaPorId(id);
        return ResponseEntity.ok(categoriaPresenter.categoriaToCategoriaDTO(categoria));
    }

    @PutMapping
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Editar cadastro de categoria")
    public ResponseEntity<CategoriaDTO> editarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = this.categoriaUseCasePort.editarCategoria(categoriaPresenter.categoriaDTOToCategoria(categoriaDTO));
        return ResponseEntity.ok(categoriaPresenter.categoriaToCategoriaDTO(categoria));
    }

    @PostMapping
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Cadastrar categoria")
    public ResponseEntity<CategoriaDTO> cadatrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = this.categoriaUseCasePort.salvarCategoria(categoriaPresenter.categoriaDTOToCategoria(categoriaDTO));
        return ResponseEntity.ok(categoriaPresenter.categoriaToCategoriaDTO(categoria));
    }


    @PutMapping("/inativar/{id}")
    @Transactional
    @Tag(name = "Categoria")
    @Operation(summary = "Ativar / Inativar categoria")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void inativarCategoria(@PathVariable Long id) {
        this.categoriaUseCasePort.inativarCategoria(id);
    }

}
