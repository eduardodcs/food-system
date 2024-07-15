package com.fiap.soat.presenters;

import com.fiap.soat.dto.CategoriaDTO;
import com.fiap.soat.dto.ProdutoDTOReceived;
import com.fiap.soat.dto.ProdutoDTOResponse;
import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPresenter {

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

}
