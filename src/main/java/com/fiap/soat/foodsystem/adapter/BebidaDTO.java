package com.fiap.soat.foodsystem.adapter;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BebidaDTO {
	
	private Long id;

	@NotBlank (message = "Nome não pode ser vazio")
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;

	@NotBlank (message = "Descrição não pode ser vazia")
	@NotNull(message = "Descrição não pode ser nula")
	private String descricao;

	@NotBlank (message = "Preço não pode ser vazio")
	@NotNull(message = "Preço não pode ser nulo")
	private BigDecimal preco;

	private boolean statusAtivo;
	
	public BebidaDTO() {
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

	public boolean isStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

}
