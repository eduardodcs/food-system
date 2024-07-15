package com.fiap.soat.services;

import com.fiap.soat.ports.PagamentoClientPort;
import com.fiap.soat.ports.PagamentoServicePort;

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
