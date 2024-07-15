package com.fiap.soat.ports;

import java.util.List;

import com.fiap.soat.entities.Categoria;

public interface CategoriaGatewayPort {

    List<Categoria> buscarCategorias();

    Categoria buscarCategoriaPorId(Long id);

    Categoria salvarCategoria(Categoria categoria);

    Categoria editarCategoria(Categoria categoria);

}