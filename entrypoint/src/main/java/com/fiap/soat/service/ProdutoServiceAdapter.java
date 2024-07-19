package com.fiap.soat.service;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.Produto;
import com.fiap.soat.dto.ProdutoDTOResponse;
import com.fiap.soat.dto.ProdutoDTOReceived;
import com.fiap.soat.presenters.ProdutoPresenter;
import com.fiap.soat.ports.usecases.CategoriaUseCasePort;
import com.fiap.soat.ports.usecases.ProdutoUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceAdapter {

    @Autowired
    private ProdutoUseCasePort produtoUseCasePort;

    @Autowired
    private CategoriaUseCasePort categoriaUseCasePort;

    @Autowired
    private ProdutoPresenter produtoPresenter;

    public ProdutoDTOResponse cadastrarProduto(ProdutoDTOReceived produtoDTOReceived) {
        Produto produto = this.produtoPresenter.produtoDTOReceivedToProduto(produtoDTOReceived);
        Categoria categoria = categoriaUseCasePort.buscarCategoriaPorId(produtoDTOReceived.getIdCategoria());
        produto.setCategoria(categoria);
        return this.produtoPresenter.produtoToProdutoDTOResponse(this.produtoUseCasePort.salvarProduto(produto));
    }

    public ProdutoDTOResponse editarProduto(ProdutoDTOReceived produtoDTOReceived) {
        Produto produto = this.produtoPresenter.produtoDTOReceivedToProduto(produtoDTOReceived);
        Categoria categoria = categoriaUseCasePort.buscarCategoriaPorId(produtoDTOReceived.getIdCategoria());
        produto.setCategoria(categoria);
        return this.produtoPresenter.produtoToProdutoDTOResponse(this.produtoUseCasePort.editarProduto(produto));
    }
}
