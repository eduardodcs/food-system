package com.fiap.soat.foodsystem.adapter.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
//@IdClass(PedidoProdutoEntityId.class)
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
//    @Transient
//    private PedidoEntity pedido;
//    @Transient
//    private ProdutoEntity produto;
    private Integer qtdeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;

}
