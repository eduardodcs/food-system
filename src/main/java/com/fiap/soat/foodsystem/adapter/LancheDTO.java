package com.fiap.soat.foodsystem.adapter;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LancheDTO {
	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotNull
	private BigDecimal preco;
	private boolean statusAtivo;
	
	public LancheDTO() {
		// TODO Auto-generated constructor stub
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public void setStatusAtivo(boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}
	
	public boolean isStatusAtivo() {
		return statusAtivo;
	}
	
	

}
