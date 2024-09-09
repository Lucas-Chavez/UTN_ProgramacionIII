package org.example.entidades;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class DetallePedido {
    private Long id;
    private Integer cantidad;
    private Double subTotal;

    private Articulo articulo;

}
