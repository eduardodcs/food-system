package com.fiap.soat.foodsystem.adapter.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.soat.foodsystem.adapter.entities.BebidaEntity;
import com.fiap.soat.foodsystem.domain.Bebida;
import com.fiap.soat.foodsystem.domain.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.ports.BebidaRepositoryPort;


@Component
public class BebidaRepositoryAdapter implements BebidaRepositoryPort {
	
	@Autowired
	private BebidaRepository bebidaRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Bebida> buscarBebidas() {
		List<BebidaEntity> listaBebidaEntity = this.bebidaRepository.findAll();
		List<Bebida> listaBebida = listaBebidaEntity.stream().map(bebidaEntity -> this.mapper.map(bebidaEntity, Bebida.class)).collect(Collectors.toList());
		return listaBebida;
	}

	@Override
	public Bebida buscarBebidaPorId(Long id) {
		BebidaEntity bebidaEntity = this.bebidaRepository.findById(id).orElseThrow(() -> new NotFoundException("Bebida não encontrada com o ID informado."));
		return this.mapper.map(bebidaEntity, Bebida.class);
	}

	@Override
	public Bebida salvarBebida(Bebida bebida) {
		BebidaEntity bebidaEntity = mapper.map(bebida, BebidaEntity.class);
		BebidaEntity bebidaSaved = this.bebidaRepository.save(bebidaEntity);
		return mapper.map(bebidaSaved, Bebida.class);
	}

	@Override
	public Bebida editarBebida(Bebida bebida) {
		BebidaEntity bebidaEntity = mapper.map(bebida, BebidaEntity.class);
		BebidaEntity bebidaSaved = this.bebidaRepository.save(bebidaEntity);
		return mapper.map(bebidaSaved, Bebida.class);
	}

}
