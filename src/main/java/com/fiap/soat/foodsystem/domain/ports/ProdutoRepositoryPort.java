package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Categoria;
import com.fiap.soat.foodsystem.domain.Produto;

public interface ProdutoRepositoryPort {
	
	List<Produto> buscarProdutosPorCategoria(Categoria categoria);
	
	Produto buscarProdutoPorId(Long id);
	
	Produto salvarProduto(Produto produto);
	
	Produto editarProduto(Produto produto);

}
