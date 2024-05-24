package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.model.Produto;

public interface ProdutoServicePort {

    List<Produto> buscarProdutosPorCategoria(Long categoriaId);

    Produto buscarProdutoPorId(Long id);

    Produto salvarProduto(Produto produto);

    Produto editarProduto(Produto produto);

    void inativarProduto(Long id);

}
