package com.fiap.soat.repository;

import com.fiap.soat.entities.PedidoEntity;
import com.fiap.soat.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatusPedido(StatusPedido statusPedido);

}
