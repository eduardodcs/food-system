package com.fiap.soat.foodsystem.domain.ports;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PagamentoServicePort {

    String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido);
}
