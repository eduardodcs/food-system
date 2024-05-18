package com.fiap.soat.foodsystem.domain.services;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Lanche;
import com.fiap.soat.foodsystem.domain.ports.LancheRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.LancheServicePort;

public class LancheService implements LancheServicePort {
	
	private LancheRepositoryPort lancheRepositoryPort;
	
	public LancheService(LancheRepositoryPort lancheRepositoryPort) {
		this.lancheRepositoryPort = lancheRepositoryPort;
	}

	@Override
	public List<Lanche> buscarLanches() {
		return this.lancheRepositoryPort.buscarLanches();
	}

	@Override
	public Lanche buscarLanchePorId(Long id) {
		return this.lancheRepositoryPort.buscarLanchePorId(id);
	}

	@Override
	public Lanche salvarLanche(Lanche lanche) {
		lanche.setStatusAtivo(true);
		return this.lancheRepositoryPort.salvarLanche(lanche);
	}

	@Override
	public Lanche editarLanche(Lanche lanche) {
		Lanche lancheOriginal = this.buscarLanchePorId(lanche.getId());
		return this.lancheRepositoryPort.editarLanche(lanche);
	}

	@Override
	public void inativarLanche(Long id) {
		Lanche lanche = this.buscarLanchePorId(id);
		lanche.setStatusAtivo(!lanche.isStatusAtivo());
		this.lancheRepositoryPort.salvarLanche(lanche);
		
	}
	
}
