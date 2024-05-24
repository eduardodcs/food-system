package com.fiap.soat.foodsystem.adapter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(PedidoProdutoEntityId.class)
@Table(name = "Pedido_Produto")
public class PedidoProdutoEntity {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "pedido_id")
    private Long pedido_id;
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "produto_id")
    private Long produto_id;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "FK_Pedido"), insertable = false, updatable = false)
//    private PedidoEntity pedido;
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "FK_Produto"), insertable = false, updatable = false)
    private ProdutoEntity produto;
    private Integer qtdeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;

}
