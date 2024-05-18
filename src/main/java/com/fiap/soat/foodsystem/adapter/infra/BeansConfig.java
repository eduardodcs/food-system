package com.fiap.soat.foodsystem.adapter.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.soat.foodsystem.domain.ports.AcompanhamentoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.AcompanhamentoServicePort;
import com.fiap.soat.foodsystem.domain.ports.LancheRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.LancheServicePort;
import com.fiap.soat.foodsystem.domain.ports.SobremesaRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.SobremesaServicePort;
import com.fiap.soat.foodsystem.domain.services.AcompanhamentoService;
import com.fiap.soat.foodsystem.domain.services.LancheService;
import com.fiap.soat.foodsystem.domain.services.SobremesaService;

@Configuration
public class BeansConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public LancheServicePort lancheServicePort(LancheRepositoryPort lancheRepositoryPort) {
		return new LancheService(lancheRepositoryPort);
	}

	@Bean
	public SobremesaServicePort sobremesaServicePort(SobremesaRepositoryPort sobremesaRepositoryPort) {
		return new SobremesaService(sobremesaRepositoryPort);
	}
	
	@Bean
	public AcompanhamentoServicePort acompanhamentoServicePort(AcompanhamentoRepositoryPort acompanhamentoRepositoryPort) {
		return new AcompanhamentoService(acompanhamentoRepositoryPort);
	}
	
}
