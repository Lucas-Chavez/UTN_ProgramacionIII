package org.example.entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DetallePedido {
    private Long id;
    private Integer cantidad;
    private Double subTotal;
    private Articulo articulo;  // Relación unidireccional a Articulo
}

