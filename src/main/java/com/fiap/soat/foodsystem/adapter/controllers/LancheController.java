package com.fiap.soat.foodsystem.adapter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.soat.foodsystem.domain.Lanche;
import com.fiap.soat.foodsystem.domain.ports.LancheServicePort;

@RestController
@RequestMapping("lanche")
public class LancheController {
	
	@Autowired
	private LancheServicePort lancheServicePort;
	
	@GetMapping
	public List<Lanche> buscarLanches(){
		return this.lancheServicePort.buscarLanches();		
	}
	
	@GetMapping("{id}")
	public Lanche buscarLanchePorId(@PathVariable Long id) {
		return this.lancheServicePort.buscarLanchePorId(id);
	}

}
