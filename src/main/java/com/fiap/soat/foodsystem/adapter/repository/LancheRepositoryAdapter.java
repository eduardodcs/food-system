package com.fiap.soat.foodsystem.adapter.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.soat.foodsystem.adapter.entities.LancheEntity;
import com.fiap.soat.foodsystem.domain.Lanche;
import com.fiap.soat.foodsystem.domain.ports.LancheRepositoryPort;

@Component
public class LancheRepositoryAdapter implements LancheRepositoryPort {

	@Autowired
	private LancheRepository lancheRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Lanche> buscarLanches() {
		List<LancheEntity> listaLancheEntity = this.lancheRepository.findAll();
		List<Lanche> listaLanche = listaLancheEntity.stream().map(lancheEntity -> this.mapper.map(lancheEntity, Lanche.class)).collect(Collectors.toList());
		return listaLanche;
	}

	@Override
	public Lanche buscarLanchePorId(Long id) {
		LancheEntity lancheEntity = this.lancheRepository.findById(id).orElse(null);
		return this.mapper.map(lancheEntity, Lanche.class);
	}

	@Override
	public Lanche salvarLanche(Lanche lanche) {
		LancheEntity lancheEntity = mapper.map(lanche, LancheEntity.class);
		LancheEntity lancheSaved = this.lancheRepository.save(lancheEntity);
		return mapper.map(lancheSaved, Lanche.class);
	}

	@Override
	public Lanche editarLanche(Lanche lanche) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
