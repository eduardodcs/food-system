package com.fiap.soat.foodsystem.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.soat.foodsystem.domain.Bebida;
import com.fiap.soat.foodsystem.domain.ports.BebidaRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.BebidaServicePort;

public class BebidaService implements BebidaServicePort {
	
	private BebidaRepositoryPort bebidaRepositoryPort;
	
	public BebidaService(BebidaRepositoryPort bebidaRepositoryPort) {
		this.bebidaRepositoryPort = bebidaRepositoryPort;
	}

	@Override
	public List<Bebida> buscarBebidas() {
		return bebidaRepositoryPort.buscarBebidas();
	}

	@Override
	public Bebida buscarBebidaPorId(Long id) {
		return bebidaRepositoryPort.buscarBebidaPorId(id);
	}

	@Override
	public Bebida salvarBebida(Bebida bebida) {
		return bebidaRepositoryPort.salvarBebida(bebida);
	}

	@Override
	public Bebida editarBebida(Bebida bebida) {
		return bebidaRepositoryPort.editarBebida(bebida);
	}

	@Override
	public void inativarBebida(Long id) {
		Bebida bebida = this.buscarBebidaPorId(id);
		bebida.setStatusAtivo(!bebida.isStatusAtivo());
		this.bebidaRepositoryPort.salvarBebida(bebida);
	}

}
