package com.fiap.soat.client;

import com.fiap.soat.ports.PagamentoGatewayPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class PagamentoGatewayAdapter implements PagamentoGatewayPort {
    @Override
    public String solicitarQRCode(Long idPedido, BigDecimal valor, LocalDateTime dataHoraPedido) {
        // FAKE - Simulando a chamado ao serviço externo de pagamento
        Random random = new Random();
        String hexString1 = Long.toHexString(random.nextLong());
        String hexString2 = Long.toHexString(random.nextLong());
        String hexString3 = Long.toHexString(random.nextLong());
        String hexString4 = Long.toHexString(random.nextLong());
        return MessageFormat.format("{0, number, 000000000000}_{1, , 00000000000000.00}_{2}_{3}_{4}_{5}_{6}"
                , idPedido, valor.doubleValue(), Math.abs(dataHoraPedido.hashCode()), hexString1, hexString2, hexString3, hexString4);

    }
}
