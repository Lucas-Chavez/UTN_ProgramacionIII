package org.example.Entidades;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Articulo {
    private Long id;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;

    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
   // @Builder.Default
    private UnidadMedida unidadMedida;
   // @Builder.Default
    private Imagen imagen;


}
