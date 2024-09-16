package org.example.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articulo")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;

    @ManyToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    @ManyToOne
    @JoinColumn(name = "unidadMedida_id")
    private UnidadMedida unidadMedida;
}