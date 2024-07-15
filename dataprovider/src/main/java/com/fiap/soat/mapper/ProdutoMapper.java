package com.fiap.soat.mapper;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.CategoriaEntity;
import com.fiap.soat.entities.Produto;
import com.fiap.soat.entities.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    @Autowired
    private ModelMapper mapper;

    public ProdutoEntity produtoToProdutoEntity(Produto produto) {
        CategoriaEntity categoriaEntity = mapper.map(produto.getCategoria(), CategoriaEntity.class);
        ProdutoEntity produtoEntity = mapper.map(produto, ProdutoEntity.class);
        produtoEntity.setCategoria(categoriaEntity);
        return produtoEntity;
    }

    public Produto produtoEntityToProduto(ProdutoEntity produtoEntity) {
        Categoria categoria = mapper.map(produtoEntity.getCategoria(), Categoria.class);
        Produto produto = mapper.map(produtoEntity, Produto.class);
        produto.setCategoria(categoria);
        return produto;
    }
}
