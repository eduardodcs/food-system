package com.fiap.soat.foodsystem.adapter.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.soat.foodsystem.domain.ports.CategoriaRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.CategoriaServicePort;
import com.fiap.soat.foodsystem.domain.ports.ProdutoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.ProdutoServicePort;
import com.fiap.soat.foodsystem.domain.services.CategoriaService;
import com.fiap.soat.foodsystem.domain.services.ProdutoService;

@Configuration
public class BeansConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ProdutoServicePort produtoServicePort(ProdutoRepositoryPort produtoRepositoryPort, CategoriaServicePort categoriaServicePort) {
		return new ProdutoService(produtoRepositoryPort, categoriaServicePort);
	}
	
	@Bean
	public CategoriaServicePort categoriaServicePort(CategoriaRepositoryPort categoriaRepositoryPort) {
		return new CategoriaService(categoriaRepositoryPort);
	}
	
}
