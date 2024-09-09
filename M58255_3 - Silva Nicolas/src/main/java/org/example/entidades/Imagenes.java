package org.example.entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Imagenes {
    private Long id;
    private String nombre;
    private String url;


}
