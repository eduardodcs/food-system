package com.fiap.soat.foodsystem.adapter.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class PedidoProdutoEntityId {

    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Long pedido_id;
    @EqualsAndHashCode.Include
    @Column(name = "produto_id")
    private Long produto_id;
}
