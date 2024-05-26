package com.fiap.soat.foodsystem.adapter.infra.config;

import com.fiap.soat.foodsystem.domain.ports.*;
import com.fiap.soat.foodsystem.domain.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ClienteServicePort clienteServicePort(ClienteRepositoryPort clienteRepositoryPort) {
		return new ClienteService(clienteRepositoryPort);
  	}

	@Bean
	public ProdutoServicePort produtoServicePort(ProdutoRepositoryPort produtoRepositoryPort, CategoriaServicePort categoriaServicePort) {
		return new ProdutoService(produtoRepositoryPort, categoriaServicePort);
	}

	@Bean
	public CategoriaServicePort categoriaServicePort(CategoriaRepositoryPort categoriaRepositoryPort) {
		return new CategoriaService(categoriaRepositoryPort);
	}

	@Bean
	public PedidoServicePort pedidoServicePort(PedidoRepositoryPort pedidoRepositoryPort, PagamentoServicePort pagamentoServicePort) {
		return new PedidoService(pedidoRepositoryPort, pagamentoServicePort);

	}

	@Bean PagamentoServicePort pagamentoServicePort(PagamentoClientPort pagamentoClientPort) {
		return new PagamentoService(pagamentoClientPort);
	}

}
