package com.fiap.soat.foodsystem.adapter.interfaces;

import com.fiap.soat.foodsystem.modules.domain.entities.PedidoEntity;
import com.fiap.soat.foodsystem.modules.domain.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatusPedido(StatusPedido statusPedido);

}
