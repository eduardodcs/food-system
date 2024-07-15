package com.fiap.soat.ports;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.Produto;

import java.util.List;

public interface ProdutoGatewayPort {

    List<Produto> buscarProdutosPorCategoria(Categoria categoria);

    Produto buscarProdutoPorId(Long id);

    Produto salvarProduto(Produto produto);

    Produto editarProduto(Produto produto);

}