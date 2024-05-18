package com.fiap.soat.foodsystem.adapter.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.soat.foodsystem.adapter.entities.AcompanhamentoEntity;
import com.fiap.soat.foodsystem.domain.Acompanhamento;
import com.fiap.soat.foodsystem.domain.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.ports.AcompanhamentoRepositoryPort;

@Component
public class AcompanhamentoRepositoryAdapter implements AcompanhamentoRepositoryPort {
	
	@Autowired
	private AcompanhamentoRepository AcompanhamentoRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Acompanhamento> buscarAcompanhamentos() {
		List<AcompanhamentoEntity> listaAcompanhamentoEntity = this.AcompanhamentoRepository.findAll();
		List<Acompanhamento> listaAcompanhamento = listaAcompanhamentoEntity.stream()
				.map(AcompanhamentoEntity -> this.mapper.map(AcompanhamentoEntity, Acompanhamento.class)).collect(Collectors.toList());
		return listaAcompanhamento;
	}

	@Override
	public Acompanhamento buscarAcompanhamentoPorId(Long id) {
		AcompanhamentoEntity AcompanhamentoEntity = this.AcompanhamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Acompanhamento não encontrado com o ID informado."));
		return this.mapper.map(AcompanhamentoEntity, Acompanhamento.class);
	}

	@Override
	public Acompanhamento salvarAcompanhamento(Acompanhamento Acompanhamento) {
		AcompanhamentoEntity AcompanhamentoEntity = mapper.map(Acompanhamento, AcompanhamentoEntity.class);
		AcompanhamentoEntity AcompanhamentoSaved = this.AcompanhamentoRepository.save(AcompanhamentoEntity);
		return this.mapper.map(AcompanhamentoSaved, Acompanhamento.class);
	}

	@Override
	public Acompanhamento editarAcompanhamento(Acompanhamento Acompanhamento) {
		AcompanhamentoEntity AcompanhamentoEntity = mapper.map(Acompanhamento, AcompanhamentoEntity.class);
		AcompanhamentoEntity AcompanhamentoSaved = this.AcompanhamentoRepository.save(AcompanhamentoEntity);
		return this.mapper.map(AcompanhamentoSaved, Acompanhamento.class);
	}
	
	

}
