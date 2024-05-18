package com.fiap.soat.foodsystem.domain.services;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Acompanhamento;
import com.fiap.soat.foodsystem.domain.ports.AcompanhamentoRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.AcompanhamentoServicePort;

public class AcompanhamentoService implements AcompanhamentoServicePort {
	
	private AcompanhamentoRepositoryPort AcompanhamentoRepositoryPort;
	
	public AcompanhamentoService(AcompanhamentoRepositoryPort AcompanhamentoRepositoryPort) {
		this.AcompanhamentoRepositoryPort = AcompanhamentoRepositoryPort;
	}

	@Override
	public List<Acompanhamento> buscarAcompanhamentos() {
		return this.AcompanhamentoRepositoryPort.buscarAcompanhamentos();
	}

	@Override
	public Acompanhamento buscarAcompanhamentoPorId(Long id) {
		return this.AcompanhamentoRepositoryPort.buscarAcompanhamentoPorId(id);
	}

	@Override
	public Acompanhamento salvarAcompanhamento(Acompanhamento Acompanhamento) {
		Acompanhamento.setStatusAtivo(true);
		return this.AcompanhamentoRepositoryPort.salvarAcompanhamento(Acompanhamento);
	}

	@Override
	public Acompanhamento editarAcompanhamento(Acompanhamento Acompanhamento) {
		Acompanhamento AcompanhamentoOriginal = this.buscarAcompanhamentoPorId(Acompanhamento.getId());
		return this.AcompanhamentoRepositoryPort.editarAcompanhamento(Acompanhamento);
	}

	@Override
	public void inativarAcompanhamento(Long id) {
		Acompanhamento Acompanhamento = this.buscarAcompanhamentoPorId(id);
		Acompanhamento.setStatusAtivo(!Acompanhamento.isStatusAtivo());
		this.AcompanhamentoRepositoryPort.salvarAcompanhamento(Acompanhamento);
	}
	

}
