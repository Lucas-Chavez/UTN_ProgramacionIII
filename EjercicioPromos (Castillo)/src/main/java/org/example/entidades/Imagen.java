package org.example.entidades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Imagen {
    private Long id;
    private String denominacion;

    private Promocion pertenece;
    private Articulo articulo;

}
