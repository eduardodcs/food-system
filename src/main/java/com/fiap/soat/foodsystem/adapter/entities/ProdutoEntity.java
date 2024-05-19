package com.fiap.soat.foodsystem.adapter.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Produto")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(nullable = false, length = 255)
	private String nome;
	@NotNull
	@Column(nullable = false, length = 510)
	private String descricao;
	@NotNull
	@Column(nullable = false, scale = 2, precision = 10)
	private BigDecimal preco;
	@ManyToOne
	@JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name="FK_Categoria"))	
	private CategoriaEntity categoria;
	@NotNull
	@Column(nullable = false)
	private boolean statusAtivo;
	@Column(nullable = false)
	private LocalDateTime dataHoraCriacao;
	
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
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}
	
	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	
	public boolean isStatusAtivo() {
		return statusAtivo;
	}
	
	public void setStatusAtivo(boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}
	
	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}
	
	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}	
	
}
