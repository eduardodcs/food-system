package com.fiap.soat.foodsystem.adapter.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.soat.foodsystem.adapter.entities.SobremesaEntity;
import com.fiap.soat.foodsystem.domain.Sobremesa;
import com.fiap.soat.foodsystem.domain.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.ports.SobremesaRepositoryPort;

@Component
public class SobremesaRepositoryAdapter implements SobremesaRepositoryPort {
	
	@Autowired
	private SobremesaRepository sobremesaRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Sobremesa> buscarSobremesas() {
		List<SobremesaEntity> listaSobremesaEntity = this.sobremesaRepository.findAll();
		List<Sobremesa> listaSobremesa = listaSobremesaEntity.stream()
				.map(sobremesaEntity -> this.mapper.map(sobremesaEntity, Sobremesa.class)).collect(Collectors.toList());
		return listaSobremesa;
	}

	@Override
	public Sobremesa buscarSobremesaPorId(Long id) {
		SobremesaEntity sobremesaEntity = this.sobremesaRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Sobremesa não encontrada com o ID informado."));
		return this.mapper.map(sobremesaEntity, Sobremesa.class);
	}

	@Override
	public Sobremesa salvarSobremesa(Sobremesa sobremesa) {
		SobremesaEntity sobremesaEntity = mapper.map(sobremesa, SobremesaEntity.class);
		SobremesaEntity sobremesaSaved = this.sobremesaRepository.save(sobremesaEntity);
		return this.mapper.map(sobremesaSaved, Sobremesa.class);
	}

	@Override
	public Sobremesa editarSobremesa(Sobremesa sobremesa) {
		SobremesaEntity sobremesaEntity = mapper.map(sobremesa, SobremesaEntity.class);
		SobremesaEntity sobremesaSaved = this.sobremesaRepository.save(sobremesaEntity);
		return this.mapper.map(sobremesaSaved, Sobremesa.class);
	}
	
	

}
