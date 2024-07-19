package com.fiap.soat.repository;

import com.fiap.soat.entities.CategoriaEntity;
import com.fiap.soat.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoria(CategoriaEntity categoria);
}
