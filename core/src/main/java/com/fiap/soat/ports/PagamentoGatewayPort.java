package com.fiap.soat.ports;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PagamentoGatewayPort {

    String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido);

}
