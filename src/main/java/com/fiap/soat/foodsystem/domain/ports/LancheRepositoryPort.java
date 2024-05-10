package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Lanche;

public interface LancheRepositoryPort {
	
	List<Lanche> buscarLanches();
	
	Lanche buscarLanchePorId(Long id);
	
	Lanche salvarLanche(Lanche lanche);
	
	Lanche editarLanche(Lanche lanche);

}
