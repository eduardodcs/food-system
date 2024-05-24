package com.fiap.soat.foodsystem.domain.services;

import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.model.Produto;
import com.fiap.soat.foodsystem.domain.ports.CategoriaServicePort;
import com.fiap.soat.foodsystem.domain.ports.ProdutoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.ProdutoServicePort;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutoService implements ProdutoServicePort  {

    private ProdutoRepositoryPort produtoRepositoryPort;

    private CategoriaServicePort categoriaServicePort;

    public ProdutoService(ProdutoRepositoryPort produtoRepositoryPort, CategoriaServicePort categoriaServicePort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
        this.categoriaServicePort = categoriaServicePort;
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return this.produtoRepositoryPort.buscarProdutoPorId(id);
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        produto.setStatusAtivo(true);
        produto.setDataHoraCriacao(LocalDateTime.now());
        return this.produtoRepositoryPort.salvarProduto(produto);
    }

    @Override
    public Produto editarProduto(Produto produto) {
        Produto produtoOriginal = this.buscarProdutoPorId(produto.getId());
        produtoOriginal.setNome(produto.getNome());
        produtoOriginal.setDescricao(produto.getDescricao());
        produtoOriginal.setPreco(produto.getPreco());
        produtoOriginal.setCategoria(produto.getCategoria());
        return this.produtoRepositoryPort.editarProduto(produtoOriginal);
    }

    @Override
    public void inativarProduto(Long id) {
        Produto produto = this.buscarProdutoPorId(id);
        produto.setStatusAtivo(!produto.isStatusAtivo());
        this.produtoRepositoryPort.salvarProduto(produto);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
        Categoria categoria = this.categoriaServicePort.buscarCategoriaPorId(categoriaId);
        return this.produtoRepositoryPort.buscarProdutosPorCategoria(categoria);
    }

}
