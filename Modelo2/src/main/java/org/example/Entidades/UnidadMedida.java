package org.example.Entidades;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class UnidadMedida {
    private Long id;
    private String denominacion;

}