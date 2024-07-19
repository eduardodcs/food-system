package com.fiap.soat.repository;

import com.fiap.soat.entities.FilaPreparo;
import com.fiap.soat.entities.FilaPreparoEntity;
import com.fiap.soat.mapper.PedidoMapper;
import com.fiap.soat.ports.gateways.FilaPreparoGatewayPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilaPreparoGatewayAdapter implements FilaPreparoGatewayPort {

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
