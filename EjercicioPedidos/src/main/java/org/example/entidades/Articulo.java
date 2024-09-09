package org.example.entidades;


import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.PrimitiveIterator;

@Data
@Builder
public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer tiempoEstimadoMinutos;

    private HashSet<DetallePedido> detallePedidos;
    private UnidadMedida unidad;
    private Imagen imagen;
}
