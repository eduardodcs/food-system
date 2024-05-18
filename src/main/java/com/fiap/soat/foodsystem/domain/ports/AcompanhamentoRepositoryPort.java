package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Acompanhamento;

public interface AcompanhamentoRepositoryPort {
	
	List<Acompanhamento> buscarAcompanhamentos();
	
	Acompanhamento buscarAcompanhamentoPorId(Long id);
	
	Acompanhamento salvarAcompanhamento(Acompanhamento sobremesa);
	
	Acompanhamento editarAcompanhamento(Acompanhamento sobremesa);

}
