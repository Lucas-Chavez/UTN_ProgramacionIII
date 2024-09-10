package org.example.entidades;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Articulo {
    private Long id;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private int tiempoEstimadoMinutos;

    //@Builder.Default
    private Imagen imagen;
    private UnidadMedida unidadMedida;


}
