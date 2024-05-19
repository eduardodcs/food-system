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

import com.fiap.soat.foodsystem.adapter.AcompanhamentoDTO;
import com.fiap.soat.foodsystem.domain.Acompanhamento;
import com.fiap.soat.foodsystem.domain.ports.AcompanhamentoServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoController {
	
	@Autowired
	private AcompanhamentoServicePort acompanhamentoServicePort;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	@Tag(name = "Acompanhamento")
	@Operation(summary = "Buscar lista de acompanhamentos disponíveis")
	public ResponseEntity<List<AcompanhamentoDTO>> buscarAcompanhamentos() {
		List<Acompanhamento> listaAcompanhamento = this.acompanhamentoServicePort.buscarAcompanhamentos();
		return ResponseEntity.ok(listaAcompanhamento.stream().map(acompanhamento -> this.mapper.map(acompanhamento, AcompanhamentoDTO.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("{id}")
	@Tag(name = "Acompanhamento")
	@Operation(summary = "Buscar acompanhamento por Id")
	public ResponseEntity<AcompanhamentoDTO> buscarAcompanhamentoPorId(@PathVariable Long id) {
		Acompanhamento acompanhamento = this.acompanhamentoServicePort.buscarAcompanhamentoPorId(id);
		return ResponseEntity.ok(this.mapper.map(acompanhamento, AcompanhamentoDTO.class));
	}
	
	@PutMapping
	@Transactional
	@Tag(name = "Acompanhamento")
	@Operation(summary = "Editar cadastro de acompanhamento")
	public ResponseEntity<AcompanhamentoDTO> editarAcompanhamento(@Valid @RequestBody AcompanhamentoDTO acompanhamentoDTO) {
		Acompanhamento acompanhamento = this.acompanhamentoServicePort.editarAcompanhamento(this.mapper.map(acompanhamentoDTO, Acompanhamento.class));
		return ResponseEntity.ok(this.mapper.map(acompanhamento, AcompanhamentoDTO.class));
	}
	
	@PostMapping
	@Transactional
	@Tag(name = "Acompanhamento")
	@Operation(summary = "Cadastrar acompanhamento")
	public ResponseEntity<AcompanhamentoDTO> cadatrarAcompanhamento(@Valid @RequestBody AcompanhamentoDTO acompanhamentoDTO) {
		Acompanhamento acompanhamento = this.acompanhamentoServicePort.salvarAcompanhamento(this.mapper.map(acompanhamentoDTO, Acompanhamento.class));
		return ResponseEntity.ok(this.mapper.map(acompanhamento, AcompanhamentoDTO.class));
	}
	
	
	@PutMapping("/inativar/{id}")
	@Transactional
	@Tag(name = "Acompanhamento")
	@Operation(summary = "Ativar / Inativar acompanhamento")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void inativarAcompanhamento(@PathVariable Long id) {
		this.acompanhamentoServicePort.inativarAcompanhamento(id);
	}
	
}
