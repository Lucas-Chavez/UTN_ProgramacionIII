package org.example.entidades;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class DetallePedido {
    private Long id;
    private int cantidad;
    private double subTotal;
    private Articulo articulo;


    public void calcularSubTotal() {
        subTotal = articulo.getPrecioVenta() * cantidad;
    }


}
