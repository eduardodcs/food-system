package com.fiap.soat.foodsystem.application.usecases;

import com.fiap.soat.foodsystem.adapter.interfaces.PagamentoClientPort;
import com.fiap.soat.foodsystem.adapter.interfaces.PagamentoServicePort;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoService implements PagamentoServicePort {

    private PagamentoClientPort pagamentoClientPort;

    public PagamentoService(PagamentoClientPort pagamentoClientPort) {
        this.pagamentoClientPort = pagamentoClientPort;
    }

    @Override
    public String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido) {
        return pagamentoClientPort.solicitarQRCode(idPedido, valor, dataHoraPedido);
    }

}
