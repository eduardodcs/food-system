package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.adapter.dto.CategoriaDTO;
import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTOReceived;
import com.fiap.soat.foodsystem.adapter.dto.ProdutoDTOResponse;
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

    public ProdutoDTOResponse produtoToProdutoDTOResponse(Produto produto) {
        CategoriaDTO categoriaDTO = mapper.map(produto.getCategoria(), CategoriaDTO.class);
        ProdutoDTOResponse produtoDTOResponse = mapper.map(produto, ProdutoDTOResponse.class);
        produtoDTOResponse.setCategoriaDTO(categoriaDTO);
        return produtoDTOResponse;
    }

    public Produto produtoDTOResponseToProduto(ProdutoDTOResponse produtoDTOResponse) {
        Categoria categoria = mapper.map(produtoDTOResponse.getCategoriaDTO(), Categoria.class);
        Produto produto = mapper.map(produtoDTOResponse, Produto.class);
        produto.setCategoria(categoria);
        return produto;
    }

    public Produto produtoDTOReceivedToProduto(ProdutoDTOReceived produtoDTOReceived) {
        return mapper.map(produtoDTOReceived, Produto.class);
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
