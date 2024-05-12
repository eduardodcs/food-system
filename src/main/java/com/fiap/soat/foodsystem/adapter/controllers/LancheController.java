package com.fiap.soat.foodsystem.adapter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.soat.foodsystem.domain.Lanche;
import com.fiap.soat.foodsystem.domain.ports.LancheServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("lanche")
public class LancheController {
	
	@Autowired
	private LancheServicePort lancheServicePort;
	
	@GetMapping
	@Tag(name = "Lanche")
	@Operation(summary = "Buscar lista de lanches disponíveis")
	public List<Lanche> buscarLanches(){
		return this.lancheServicePort.buscarLanches();		
	}
	
	@GetMapping("{id}")
	@Tag(name = "Lanche")
	@Operation(summary = "Buscar lanches pelo Id")
	public Lanche buscarLanchePorId(@PathVariable Long id) {
		return this.lancheServicePort.buscarLanchePorId(id);
	}

}
