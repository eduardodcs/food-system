package com.fiap.soat.foodsystem.adapter.interfaces;

import java.util.List;

import com.fiap.soat.foodsystem.modules.domain.model.Categoria;
import com.fiap.soat.foodsystem.modules.domain.model.Produto;

public interface ProdutoRepositoryPort {

    List<Produto> buscarProdutosPorCategoria(Categoria categoria);

    Produto buscarProdutoPorId(Long id);

    Produto salvarProduto(Produto produto);

    Produto editarProduto(Produto produto);

}