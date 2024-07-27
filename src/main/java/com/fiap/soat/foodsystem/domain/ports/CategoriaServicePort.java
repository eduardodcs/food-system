package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.model.Categoria;

public interface CategoriaServicePort {

    Categoria salvarCategoria(Categoria categoria);

    Categoria editarCategoria(Categoria categoria);

    void inativarCategoria(Long id);

    List<Categoria> buscarCategorias();

    Categoria buscarCategoriaPorId(Long id);

}