package com.fiap.soat.foodsystem.adapter.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.soat.foodsystem.adapter.BebidaDTO;
import com.fiap.soat.foodsystem.domain.Bebida;
import com.fiap.soat.foodsystem.domain.ports.BebidaServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/bebida")
public class BebidaController {
	
	@Autowired
	private BebidaServicePort bebidaServicePort;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	@Tag(name = "Bebida")
	@Operation(summary = "Buscar lista de bebidas disponíveis")
	public ResponseEntity<List<BebidaDTO>> buscarBebidas(){
		List<Bebida> listaBebida = this.bebidaServicePort.buscarBebidas();	
		return ResponseEntity.ok(listaBebida.stream().map(bebida -> mapper.map(bebida, BebidaDTO.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("{id}")
	@Tag(name = "Bebida")
	@Operation(summary = "Buscar bebida pelo id")
	public ResponseEntity<BebidaDTO>
	buscarBebidaPorId(@PathVariable Long id){
		Bebida bebida = this.bebidaServicePort.buscarBebidaPorId(id);	
		return ResponseEntity.ok(mapper.map(bebida, BebidaDTO.class));
	}
	
	@PutMapping
	@Tag(name = "Bebida")
	@Operation(summary = "Editar cadastro de bebidas")
	public ResponseEntity<BebidaDTO> editarBebida(@Validated @RequestBody BebidaDTO bebidaDTO){
		Bebida bebida = this.bebidaServicePort.editarBebida(mapper.map(bebidaDTO, Bebida.class));	
		return ResponseEntity.ok(mapper.map(bebida, BebidaDTO.class));
	}
	
	@PostMapping
	@Tag(name = "Bebida")
	@Operation(summary = "Cadastrar bebida")
	public ResponseEntity<BebidaDTO> cadastrarBebida(@Validated @RequestBody BebidaDTO bebidaDTO){
		Bebida bebida = this.bebidaServicePort.salvarBebida(mapper.map(bebidaDTO, Bebida.class));	
		return ResponseEntity.ok(mapper.map(bebida, BebidaDTO.class));
	}
	
	@PutMapping("/inativar/{id}")
	@Transactional
	@Tag(name = "Bebida")
	@Operation(summary = "Ativar / Inativar bebida")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void inativarBebida(@PathVariable Long id) {
		this.bebidaServicePort.inativarBebida(id);
	}

}
