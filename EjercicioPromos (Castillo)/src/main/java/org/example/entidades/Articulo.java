package org.example.entidades;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

@Data
@Builder
public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;

    private HashSet<Promocion> promociones;
    private Imagen imagen;
    private UnidadMedida unidadMedida;
}
