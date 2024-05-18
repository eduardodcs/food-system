package com.fiap.soat.foodsystem.domain;

import java.math.BigDecimal;

public class Acompanhamento {
	
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private boolean statusAtivo;
	
	public Acompanhamento() {
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
