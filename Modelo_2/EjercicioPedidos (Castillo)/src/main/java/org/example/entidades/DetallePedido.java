package org.example.entidades;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetallePedido {
    private Long id;
    private Integer cantidad;
    private Double subTotal;

    private Pedido pedido;
    private Articulo articulo;
}
