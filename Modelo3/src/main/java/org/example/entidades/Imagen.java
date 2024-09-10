package org.example.entidades;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class Imagen {
    private Long id;
    private String denominacion;
    private String url;

}
