package org.example.entidades;

import lombok.*;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockMaximo;
    private Integer tiempoEstimadoMinutos;

    private UnidadMedida unidad;

    private Imagenes imagen;
}
