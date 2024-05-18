package com.fiap.soat.foodsystem.domain.services;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Sobremesa;
import com.fiap.soat.foodsystem.domain.ports.SobremesaRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.SobremesaServicePort;

public class SobremesaService implements SobremesaServicePort {
	
	private SobremesaRepositoryPort sobremesaRepositoryPort;
	
	public SobremesaService(SobremesaRepositoryPort sobremesaRepositoryPort) {
		this.sobremesaRepositoryPort = sobremesaRepositoryPort;
	}

	@Override
	public List<Sobremesa> buscarSobremesas() {
		return this.sobremesaRepositoryPort.buscarSobremesas();
	}

	@Override
	public Sobremesa buscarSobremesaPorId(Long id) {
		return this.sobremesaRepositoryPort.buscarSobremesaPorId(id);
	}

	@Override
	public Sobremesa salvarSobremesa(Sobremesa sobremesa) {
		sobremesa.setStatusAtivo(true);
		return this.sobremesaRepositoryPort.salvarSobremesa(sobremesa);
	}

	@Override
	public Sobremesa editarSobremesa(Sobremesa sobremesa) {
		Sobremesa sobremesaOriginal = this.buscarSobremesaPorId(sobremesa.getId());
		return this.sobremesaRepositoryPort.editarSobremesa(sobremesa);
	}

	@Override
	public void inativarSobremesa(Long id) {
		Sobremesa sobremesa = this.buscarSobremesaPorId(id);
		sobremesa.setStatusAtivo(!sobremesa.isStatusAtivo());
		this.sobremesaRepositoryPort.salvarSobremesa(sobremesa);
	}
	

}
