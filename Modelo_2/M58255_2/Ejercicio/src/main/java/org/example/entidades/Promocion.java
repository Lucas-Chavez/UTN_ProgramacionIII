package org.example.entidades;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "tipoPromocion")
@Builder
public class Promocion {
    private Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private String precioPromocional;
    private TipoPromocion tipoPromocion;

    @Builder.Default
    private Set<Imagen> promoImagen = new HashSet<>();

    @Builder.Default
    private Set<Articulo> promociones = new HashSet<>();
}
