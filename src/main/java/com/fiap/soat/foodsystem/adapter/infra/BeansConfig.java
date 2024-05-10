package com.fiap.soat.foodsystem.adapter.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.soat.foodsystem.domain.ports.LancheRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.LancheServicePort;
import com.fiap.soat.foodsystem.domain.services.LancheService;

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
	
}
