package com.fiap.soat.ports.usecases;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PagamentoUseCasePort {

    String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido);
}
