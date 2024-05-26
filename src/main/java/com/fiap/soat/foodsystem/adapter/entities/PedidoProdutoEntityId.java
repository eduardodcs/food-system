package com.fiap.soat.foodsystem.adapter.entities;


import com.fiap.soat.foodsystem.domain.model.Pedido;
import com.fiap.soat.foodsystem.domain.model.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class PedidoProdutoEntityId {

    @ManyToOne(targetEntity = PedidoEntity.class)
    @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "FK_Pedido"))
    @EqualsAndHashCode.Exclude
    private PedidoEntity pedido_id;
    @ManyToOne(targetEntity = ProdutoEntity.class)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "FK_Produto"))
    private ProdutoEntity produto_id;
}
