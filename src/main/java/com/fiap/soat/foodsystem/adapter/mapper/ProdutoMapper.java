package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.adapter.dto.CategoriaDTO;
import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTO;
import com.fiap.soat.foodsystem.adapter.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.adapter.entities.ProdutoEntity;
import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    @Autowired
    private ModelMapper mapper;

    public ProdutoDTO produtoToProdutoDTO(Produto produto) {
        CategoriaDTO categoriaDTO = mapper.map(produto.getCategoria(), CategoriaDTO.class);
        ProdutoDTO produtoDTO = mapper.map(produto, ProdutoDTO.class);
        produtoDTO.setCategoriaDTO(categoriaDTO);
        return produtoDTO;
    }

    public Produto produtoDTOToProduto(ProdutoDTO produtoDTO) {
        Categoria categoria = mapper.map(produtoDTO.getCategoriaDTO(), Categoria.class);
        Produto produto = mapper.map(produtoDTO, Produto.class);
        produto.setCategoria(categoria);
        return produto;
    }

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
