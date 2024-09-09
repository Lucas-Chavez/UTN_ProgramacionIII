package org.example.entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer tiempoEstimadoMinutos;
    private UnidadMedida unidad;
    private Imagenes imagen;
}

