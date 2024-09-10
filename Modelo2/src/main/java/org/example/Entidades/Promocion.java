package org.example.Entidades;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Promocion {
    private Long id;
    private String denominacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalTime HoraDesde;
    private LocalTime HoraHasta;
    private String descripcionDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;


   //@Builder.Default
    private Set<Imagen> promoImagen = new HashSet<>();

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

}
