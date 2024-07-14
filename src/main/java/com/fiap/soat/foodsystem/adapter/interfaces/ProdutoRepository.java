package com.fiap.soat.foodsystem.adapter.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.soat.foodsystem.modules.domain.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.modules.domain.entities.ProdutoEntity;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoria(CategoriaEntity categoria);
}
