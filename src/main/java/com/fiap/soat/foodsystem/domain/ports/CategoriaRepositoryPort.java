package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.model.Categoria;

public interface CategoriaRepositoryPort {

    List<Categoria> buscarCategorias();

    Categoria buscarCategoriaPorId(Long id);

    Categoria salvarCategoria(Categoria categoria);

    Categoria editarCategoria(Categoria categoria);

}