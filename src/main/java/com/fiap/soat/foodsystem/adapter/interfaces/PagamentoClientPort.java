package com.fiap.soat.foodsystem.adapter.interfaces;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PagamentoClientPort {

    String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido);

}
