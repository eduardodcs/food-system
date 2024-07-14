package com.fiap.soat.foodsystem.modules.domain.entities;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class PedidoProdutoEntityId {

    @ManyToOne(targetEntity = PedidoEntity.class)
    @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "FK_Pedido_Produto"))
    @EqualsAndHashCode.Exclude
    private PedidoEntity pedido_id;
    @ManyToOne(targetEntity = ProdutoEntity.class)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "FK_Produto_Pedido"))
    private ProdutoEntity produto_id;
}
