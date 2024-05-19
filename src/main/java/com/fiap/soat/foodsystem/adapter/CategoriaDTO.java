package com.fiap.soat.foodsystem.adapter;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	private boolean statusAtivo;
	
	public CategoriaDTO() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatusAtivo() {
		return statusAtivo;
	}
	
	public void setStatusAtivo(boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}
	

}
