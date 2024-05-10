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
		// aplicar validações antes de salvar
		return this.lancheRepositoryPort.salvarLanche(lanche);
	}

	@Override
	public Lanche editarLanche(Lanche lanche) {
		// aplicar validações antes de salvar
		return this.lancheRepositoryPort.editarLanche(lanche);
	}
	
}
