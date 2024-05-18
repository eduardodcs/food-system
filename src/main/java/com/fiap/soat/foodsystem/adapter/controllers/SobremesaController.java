package com.fiap.soat.foodsystem.adapter.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.soat.foodsystem.adapter.SobremesaDTO;
import com.fiap.soat.foodsystem.domain.Sobremesa;
import com.fiap.soat.foodsystem.domain.ports.SobremesaServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("sobremesa")
public class SobremesaController {
	
	@Autowired
	private SobremesaServicePort sobremesaServicePort;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	@Tag(name = "Sobremesa")
	@Operation(summary = "Buscar lista de sobremesas disponíveis")
	public ResponseEntity<List<Sobremesa>> buscarSobremesas() {
		List<Sobremesa> listaSobremesa = this.sobremesaServicePort.buscarSobremesas();
		return ResponseEntity.ok(listaSobremesa.stream().map(sobremesa -> this.mapper.map(sobremesa, Sobremesa.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("{id}")
	@Tag(name = "Sobremesa")
	@Operation(summary = "Buscar sobremesa por Id")
	public ResponseEntity<SobremesaDTO> buscarSobremesaPorId(@PathVariable Long id) {
		Sobremesa sobremesa = this.sobremesaServicePort.buscarSobremesaPorId(id);
		return ResponseEntity.ok(this.mapper.map(sobremesa, SobremesaDTO.class));
	}
	
	@PutMapping
	@Transactional
	@Tag(name = "Sobremesa")
	@Operation(summary = "Editar cadastro de sobremesa")
	public ResponseEntity<SobremesaDTO> editarSobremesa(@Valid @RequestBody SobremesaDTO sobremesaDTO) {
		Sobremesa sobremesa = this.sobremesaServicePort.editarSobremesa(this.mapper.map(sobremesaDTO, Sobremesa.class));
		return ResponseEntity.ok(this.mapper.map(sobremesa, SobremesaDTO.class));
	}
	
	@PostMapping
	@Transactional
	@Tag(name = "Sobremesa")
	@Operation(summary = "Cadastrar sobremesa")
	public ResponseEntity<SobremesaDTO> cadatrarSobremesa(@Valid @RequestBody SobremesaDTO sobremesaDTO) {
		Sobremesa sobremesa = this.sobremesaServicePort.salvarSobremesa(this.mapper.map(sobremesaDTO, Sobremesa.class));
		return ResponseEntity.ok(this.mapper.map(sobremesa, SobremesaDTO.class));
	}
	
	
	@PutMapping("/inativar/{id}")
	@Transactional
	@Tag(name = "Sobremesa")
	@Operation(summary = "Ativar / Inativar sobremesa")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void inativarSobremesa(@PathVariable Long id) {
		this.sobremesaServicePort.inativarSobremesa(id);
	}
	
}
