package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCalle;
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}