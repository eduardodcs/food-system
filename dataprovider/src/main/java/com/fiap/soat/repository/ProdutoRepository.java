package com.fiap.soat.foodsystem.adapter.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.soat.foodsystem.adapter.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.adapter.entities.ProdutoEntity;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoria(CategoriaEntity categoria);
}
