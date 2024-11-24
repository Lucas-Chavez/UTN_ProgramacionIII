package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private double subtotal;

    @ManyToOne
    private Articulo articulo;

    @ManyToOne
    private Factura factura;
}