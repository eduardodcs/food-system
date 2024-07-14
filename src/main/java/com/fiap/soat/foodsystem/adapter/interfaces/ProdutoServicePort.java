package com.fiap.soat.foodsystem.adapter.interfaces;

import java.util.List;

import com.fiap.soat.foodsystem.modules.domain.model.Produto;

public interface ProdutoServicePort {

    List<Produto> buscarProdutosPorCategoria(Long categoriaId);

    Produto buscarProdutoPorId(Long id);

    Produto salvarProduto(Produto produto);

    Produto editarProduto(Produto produto);

    void inativarProduto(Long id);

}
