package com.fiap.soat.config;

import com.fiap.soat.ports.*;
import com.fiap.soat.usecases.*;
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
	public ClienteUseCasePort clienteServicePort(ClienteGatewayPort clienteGatewayPort) {
		return new ClienteUseCase(clienteGatewayPort);
  	}

	@Bean
	public ProdutoUseCasePort produtoServicePort(ProdutoGatewayPort produtoGatewayPort, CategoriaUseCasePort categoriaUseCasePort) {
		return new ProdutoUseCase(produtoGatewayPort, categoriaUseCasePort);
	}

	@Bean
	public CategoriaUseCasePort categoriaServicePort(CategoriaGatewayPort categoriaRepositoryPort) {
		return new CategoriaUseCase(categoriaRepositoryPort);
	}

	@Bean
	public PedidoUseCasePort pedidoServicePort(PedidoGatewayPort pedidoGatewayPort, PagamentoUseCasePort pagamentoUseCasePort,
											   FilaPreparoUseCasePort filaPreparoUseCasePort) {
		return new PedidoUseCase(pedidoGatewayPort, pagamentoUseCasePort, filaPreparoUseCasePort);
	}

	@Bean
	PagamentoUseCasePort pagamentoServicePort(PagamentoGatewayPort pagamentoGatewayPort) {
		return new PagamentoUseCase(pagamentoGatewayPort);
	}

	@Bean
	FilaPreparoUseCasePort filaPreparoServicePort(FilaPreparoGatewayPort filaPreparoGatewayPort) {
		return new FilaPedidoUseCase(filaPreparoGatewayPort);
	}




}
