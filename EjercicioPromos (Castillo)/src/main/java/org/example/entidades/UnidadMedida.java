package org.example.entidades;


import lombok.Builder;
import lombok.Data;

import java.util.HashSet;

@Data
@Builder
public class UnidadMedida {
    private Long id;
    private String denominacion;

    private HashSet<Articulo> relacionados;
}
