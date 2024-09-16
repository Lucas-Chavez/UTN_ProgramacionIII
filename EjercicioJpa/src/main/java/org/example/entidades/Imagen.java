package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "imagenes")


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Imagen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    /*private Promocion pertenece;
    private Articulo articulo;*/

}
