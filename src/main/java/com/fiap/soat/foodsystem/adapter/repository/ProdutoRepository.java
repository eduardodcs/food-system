package com.fiap.soat.foodsystem.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.soat.foodsystem.adapter.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.adapter.entities.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findByCategoria(CategoriaEntity categoria);

}
