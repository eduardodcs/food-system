package com.fiap.soat.usecases;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.Produto;
import com.fiap.soat.ports.CategoriaUseCasePort;
import com.fiap.soat.ports.ProdutoGatewayPort;
import com.fiap.soat.ports.ProdutoUseCasePort;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutoUseCase implements ProdutoUseCasePort {

    private ProdutoGatewayPort produtoGatewayPort;

    private CategoriaUseCasePort categoriaUseCasePort;

    public ProdutoUseCase(ProdutoGatewayPort produtoGatewayPort, CategoriaUseCasePort categoriaUseCasePort) {
        this.produtoGatewayPort = produtoGatewayPort;
        this.categoriaUseCasePort = categoriaUseCasePort;
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return this.produtoGatewayPort.buscarProdutoPorId(id);
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        produto.setId(null);
        produto.setStatusAtivo(true);
        produto.setDataHoraCriacao(LocalDateTime.now());
        return this.produtoGatewayPort.salvarProduto(produto);
    }

    @Override
    public Produto editarProduto(Produto produto) {
        Produto produtoOriginal = this.buscarProdutoPorId(produto.getId());
        produtoOriginal.setNome(produto.getNome());
        produtoOriginal.setDescricao(produto.getDescricao());
        produtoOriginal.setPreco(produto.getPreco());
        produtoOriginal.setCategoria(produto.getCategoria());
        return this.produtoGatewayPort.editarProduto(produtoOriginal);
    }

    @Override
    public void inativarProduto(Long id) {
        Produto produto = this.buscarProdutoPorId(id);
        produto.setStatusAtivo(!produto.isStatusAtivo());
        this.produtoGatewayPort.salvarProduto(produto);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
        Categoria categoria = this.categoriaUseCasePort.buscarCategoriaPorId(categoriaId);
        return this.produtoGatewayPort.buscarProdutosPorCategoria(categoria);
    }

}
