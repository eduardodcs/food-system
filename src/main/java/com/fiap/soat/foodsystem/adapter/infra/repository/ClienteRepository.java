package com.fiap.soat.foodsystem.adapter.infra.repository;

import com.fiap.soat.foodsystem.adapter.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Optional<ClienteEntity> findByCpf(String cpf);
}
