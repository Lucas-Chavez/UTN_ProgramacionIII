package org.example.entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class UnidadMedida {
    private Long id;
    private String denominacion;
}
