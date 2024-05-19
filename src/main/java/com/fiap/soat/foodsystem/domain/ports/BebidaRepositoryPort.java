package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Bebida;

public interface BebidaRepositoryPort {

	List<Bebida> buscarBebidas();
	
	Bebida buscarBebidaPorId(Long id);
	
	Bebida salvarBebida(Bebida bebida);
	
	Bebida editarBebida(Bebida bebida);
}
