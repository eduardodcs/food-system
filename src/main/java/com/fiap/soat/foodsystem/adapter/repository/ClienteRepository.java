package com.fiap.soat.foodsystem.adapter.repository;

import com.fiap.soat.foodsystem.adapter.entities.ClienteEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    @Override
    boolean existsById(String id);

    boolean existsByEmail(String email);
}
