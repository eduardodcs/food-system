package com.fiap.soat.foodsystem.adapter.infra.repository;

import com.fiap.soat.foodsystem.adapter.entities.FilaPreparoEntity;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoMapper;
import com.fiap.soat.foodsystem.domain.model.FilaPreparo;
import com.fiap.soat.foodsystem.domain.ports.FilaPreparoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FilaPreparoRepositoryAdapter implements FilaPreparoRepositoryPort {

    @Autowired
    private FilaPreparoRepository filaPreparoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public void enviarPedidoParaFilaPreparo(FilaPreparo filaPreparo) {
        FilaPreparoEntity filaPreparoEntity = new FilaPreparoEntity();
        filaPreparoEntity.setId(filaPreparo.getId());
        filaPreparoEntity.setPedidoEntity(this.pedidoMapper.pedidoToPedidoEntity(filaPreparo.getPedido()));
        filaPreparoEntity.setPedido_id(filaPreparo.getPedido().getId());
        filaPreparoEntity.setLocalDateTime(filaPreparo.getDataHoraCriacao());
        filaPreparoRepository.save(filaPreparoEntity);
    }
}
