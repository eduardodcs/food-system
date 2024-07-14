package com.fiap.soat.foodsystem.infrastructure.repository;

import com.fiap.soat.foodsystem.adapter.interfaces.FilaPreparoRepository;
import com.fiap.soat.foodsystem.modules.domain.entities.FilaPreparoEntity;
import com.fiap.soat.foodsystem.adapter.mapper.PedidoMapper;
import com.fiap.soat.foodsystem.modules.domain.model.FilaPreparo;
import com.fiap.soat.foodsystem.adapter.interfaces.FilaPreparoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
