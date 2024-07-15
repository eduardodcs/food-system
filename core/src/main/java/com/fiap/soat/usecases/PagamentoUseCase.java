package com.fiap.soat.usecases;

import com.fiap.soat.ports.PagamentoGatewayPort;
import com.fiap.soat.ports.PagamentoUseCasePort;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoUseCase implements PagamentoUseCasePort {

    private PagamentoGatewayPort pagamentoGatewayPort;

    public PagamentoUseCase(PagamentoGatewayPort pagamentoGatewayPort) {
        this.pagamentoGatewayPort = pagamentoGatewayPort;
    }

    @Override
    public String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido) {
        return pagamentoGatewayPort.solicitarQRCode(idPedido, valor, dataHoraPedido);
    }

}
