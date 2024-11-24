package org.example.entidades;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Factura> facturas = new ArrayList<>();
}
