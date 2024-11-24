package org.example.entidades;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Imagen {
    private Long id;
    private String denominacion;
}
