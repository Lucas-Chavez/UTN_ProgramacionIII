package org.example.entidades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Imagen {
    private Long id;
    private String nombre;
    private String url;
}
