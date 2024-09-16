package org.example.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidad_medida")


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UnidadMedida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

}
