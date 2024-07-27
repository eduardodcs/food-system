package com.fiap.soat.foodsystem.adapter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "FilaPreparo")
public class FilaPreparoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pedido_id")
    private Long pedido_id;
    @OneToOne
    @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "FK_Pedido_FilaPreparo"), updatable = false, insertable = false)
    private PedidoEntity pedidoEntity;
    private LocalDateTime localDateTime;

}
