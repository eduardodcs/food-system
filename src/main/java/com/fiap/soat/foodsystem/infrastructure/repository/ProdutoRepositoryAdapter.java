package com.fiap.soat.foodsystem.infrastructure.repository;

import com.fiap.soat.foodsystem.adapter.interfaces.ProdutoRepository;
import com.fiap.soat.foodsystem.modules.domain.entities.ProdutoEntity;
import com.fiap.soat.foodsystem.adapter.mapper.CategoriaMapper;
import com.fiap.soat.foodsystem.adapter.mapper.ProdutoMapper;
import com.fiap.soat.foodsystem.common.exception.NotFoundException;
import com.fiap.soat.foodsystem.modules.domain.model.Categoria;
import com.fiap.soat.foodsystem.modules.domain.model.Produto;
import com.fiap.soat.foodsystem.adapter.interfaces.ProdutoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public Produto buscarProdutoPorId(Long id) {
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado com o ID informado."));
       return this.produtoMapper.produtoEntityToProduto(produtoEntity);
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        ProdutoEntity produtoEntity = this.produtoRepository.save(this.produtoMapper.produtoToProdutoEntity(produto));
        return this.produtoMapper.produtoEntityToProduto(produtoEntity);
    }

    @Override
    public Produto editarProduto(Produto produto) {
        ProdutoEntity produtoEntitySaved = this.produtoRepository.save(this.produtoMapper.produtoToProdutoEntity(produto));
        return this.produtoMapper.produtoEntityToProduto(produtoEntitySaved);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
        List<ProdutoEntity> listaProdutoEntity = this.produtoRepository.findByCategoria(this.categoriaMapper.categoriaToCategoriaEntity(categoria));
        return listaProdutoEntity.stream().map(produtoEntity -> this.produtoMapper.produtoEntityToProduto(produtoEntity)).toList();
    }
}
