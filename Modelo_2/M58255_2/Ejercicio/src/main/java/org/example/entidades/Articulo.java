package org.example.entidades;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"imagen", "unidadMedida"})
@Builder

public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Imagen imagen;
    private UnidadMedida unidadMedida;
}
