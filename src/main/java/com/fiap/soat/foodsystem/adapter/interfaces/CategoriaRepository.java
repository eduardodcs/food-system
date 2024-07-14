package com.fiap.soat.foodsystem.adapter.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.soat.foodsystem.modules.domain.entities.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
