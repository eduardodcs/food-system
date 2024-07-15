package com.fiap.soat.ports.usecases;

import com.fiap.soat.entities.Produto;

import java.util.List;

public interface ProdutoUseCasePort {

    List<Produto> buscarProdutosPorCategoria(Long categoriaId);

    Produto buscarProdutoPorId(Long id);

    Produto salvarProduto(Produto produto);

    Produto editarProduto(Produto produto);

    void inativarProduto(Long id);

}
