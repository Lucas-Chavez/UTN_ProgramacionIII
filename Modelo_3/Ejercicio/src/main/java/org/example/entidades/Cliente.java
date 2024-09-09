package org.example.entidades;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    @Builder.Default
    private Set<Pedido> hace = new HashSet<>();  // Relación unidireccional a Pedido
}
