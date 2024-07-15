package com.fiap.soat.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "Pedido_Produto")
public class PedidoProdutoEntity {

    @EmbeddedId
    private PedidoProdutoEntityId id;
    @MapsId("pedido_id")
    @Column(insertable=false, updatable=false)
    private Long pedido_id;
    @MapsId("produto_id")
    @Column(insertable=false, updatable=false)
    private Long produto_id;
    private Integer qtdeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;

}
