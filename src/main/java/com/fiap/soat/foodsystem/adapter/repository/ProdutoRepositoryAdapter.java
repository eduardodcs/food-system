package com.fiap.soat.foodsystem.adapter.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.soat.foodsystem.adapter.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.adapter.entities.ProdutoEntity;
import com.fiap.soat.foodsystem.domain.Categoria;
import com.fiap.soat.foodsystem.domain.Produto;
import com.fiap.soat.foodsystem.domain.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.ports.ProdutoRepositoryPort;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private CategoriaRepositoryAdapter categoriaRepositoryAdapter;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Produto buscarProdutoPorId(Long id) {
		ProdutoEntity produtoEntity = this.produtoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto não encontrado com o ID informado."));
		Produto produto = this.mapper.map(produtoEntity, Produto.class);
		Categoria categoria = this.mapper.map(produtoEntity.getCategoria(), Categoria.class);
		produto.setCategoria(categoria);
		return produto;
	}

	@Override
	public Produto salvarProduto(Produto produto) {
		ProdutoEntity produtoEntity = mapper.map(produto, ProdutoEntity.class);
		CategoriaEntity categoriaEntity = mapper.map(produtoEntity.getCategoria(), CategoriaEntity.class);
		produtoEntity.setCategoria(categoriaEntity);
		
		ProdutoEntity produtoEntitySaved = this.produtoRepository.save(produtoEntity);
		Produto produtoSaved = mapper.map(produtoEntitySaved, Produto.class);
		Categoria categoria = categoriaRepositoryAdapter.buscarCategoriaPorId(produtoSaved.getCategoria().getId());
		produtoSaved.setCategoria(categoria);
		return produtoSaved;
	}

	@Override
	public Produto editarProduto(Produto produto) {
		ProdutoEntity produtoEntity = mapper.map(produto, ProdutoEntity.class);
		CategoriaEntity categoriaEntity = mapper.map(produtoEntity.getCategoria(), CategoriaEntity.class);
		produtoEntity.setCategoria(categoriaEntity);
		
		ProdutoEntity produtoEntitySaved = this.produtoRepository.save(produtoEntity);
		Produto produtoSaved = mapper.map(produtoEntitySaved, Produto.class);
		Categoria categoria = categoriaRepositoryAdapter.buscarCategoriaPorId(produtoSaved.getCategoria().getId());
		produtoSaved.setCategoria(categoria);
		return produtoSaved;
	}

	@Override
	public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
		List<ProdutoEntity> listaProdutoEntity = this.produtoRepository.findByCategoria(this.mapper.map(categoria, CategoriaEntity.class));
		List<Produto> listaProduto = listaProdutoEntity.stream().map(produtoEntity -> {
				Produto produto = this.mapper.map(produtoEntity, Produto.class);
				Categoria categoriaProduto = this.mapper.map(produtoEntity.getCategoria(), Categoria.class);
				produto.setCategoria(categoriaProduto);
				return produto;				
			}).collect(Collectors.toList());
		return listaProduto;
	}

}
