package com.fiap.soat.foodsystem.domain;

import java.math.BigDecimal;

public class Lanche {
	
	// aplicar conceitos do ValueObject
	
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	
	public Lanche() {
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
