package com.fiap.soat.repository;

import com.fiap.soat.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Optional<ClienteEntity> findByCpf(String cpf);
}
