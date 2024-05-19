package com.fiap.soat.foodsystem.domain.ports;

import java.util.List;

import com.fiap.soat.foodsystem.domain.Sobremesa;

public interface SobremesaServicePort {
	
	List<Sobremesa> buscarSobremesas();
	
	Sobremesa buscarSobremesaPorId(Long id);
	
	Sobremesa salvarSobremesa(Sobremesa sobremesa);
	
	Sobremesa editarSobremesa(Sobremesa sobremesa);
	
	void inativarSobremesa(Long id);

}
