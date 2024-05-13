package com.fiap.soat.foodsystem.adapter.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.soat.foodsystem.adapter.LancheDTO;
import com.fiap.soat.foodsystem.domain.Lanche;
import com.fiap.soat.foodsystem.domain.ports.LancheServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("lanche")
public class LancheController {
	
	@Autowired
	private LancheServicePort lancheServicePort;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	@Tag(name = "Lanche")
	@Operation(summary = "Buscar lista de lanches disponíveis")
	public ResponseEntity<List<LancheDTO>> buscarLanches(){
		List<Lanche> listaLanche = this.lancheServicePort.buscarLanches();	
		return ResponseEntity.ok(listaLanche.stream().map(lanche -> mapper.map(lanche, LancheDTO.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("{id}")
	@Tag(name = "Lanche")
	@Operation(summary = "Buscar lanches pelo Id")
	public ResponseEntity<LancheDTO> buscarLanchePorId(@PathVariable Long id) {
		Lanche lanche = this.lancheServicePort.buscarLanchePorId(id);
		return ResponseEntity.ok(mapper.map(lanche, LancheDTO.class));
	}
	
	@PutMapping
	@Transactional
	@Tag(name = "Lanche")
	@Operation(summary = "Editar cadastro de lanche")
	public ResponseEntity<LancheDTO> editarLanche(@Validated @RequestBody LancheDTO lancheDTO) {
		Lanche lanche = this.lancheServicePort.editarLanche(mapper.map(lancheDTO, Lanche.class));
		return ResponseEntity.ok(mapper.map(lanche, LancheDTO.class));
	}
	
	@PostMapping
	@Transactional
	@Tag(name = "Lanche")
	@Operation(summary = "Cadastrar lanche")
	public ResponseEntity<LancheDTO> cadastrarLanche(@Validated @RequestBody LancheDTO lancheDTO) {
		Lanche lanche = this.lancheServicePort.salvarLanche(mapper.map(lancheDTO, Lanche.class));
		return ResponseEntity.ok(mapper.map(lanche, LancheDTO.class));
	}
}
