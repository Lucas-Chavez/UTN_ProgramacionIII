package org.example.entidades;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;

@Data
@Builder
public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    private HashSet<Pedido> hace;
}
