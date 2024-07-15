package com.fiap.soat.foodsystem.adapter.service;

import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTOReceived;
import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTOResponse;
import com.fiap.soat.foodsystem.adapter.mapper.ProdutoMapper;
import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.model.Produto;
import com.fiap.soat.foodsystem.domain.ports.CategoriaServicePort;
import com.fiap.soat.foodsystem.domain.ports.ProdutoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceAdapter {

    @Autowired
    private ProdutoServicePort produtoServicePort;

    @Autowired
    private CategoriaServicePort categoriaServicePort;

    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoDTOResponse cadastrarProduto(ProdutoDTOReceived produtoDTOReceived) {
        Produto produto = this.produtoMapper.produtoDTOReceivedToProduto(produtoDTOReceived);
        Categoria categoria = categoriaServicePort.buscarCategoriaPorId(produtoDTOReceived.getIdCategoria());
        produto.setCategoria(categoria);
        return this.produtoMapper.produtoToProdutoDTOResponse(this.produtoServicePort.salvarProduto(produto));
    }

    public ProdutoDTOResponse editarProduto(ProdutoDTOReceived produtoDTOReceived) {
        Produto produto = this.produtoMapper.produtoDTOReceivedToProduto(produtoDTOReceived);
        Categoria categoria = categoriaServicePort.buscarCategoriaPorId(produtoDTOReceived.getIdCategoria());
        produto.setCategoria(categoria);
        return this.produtoMapper.produtoToProdutoDTOResponse(this.produtoServicePort.editarProduto(produto));
    }
}
