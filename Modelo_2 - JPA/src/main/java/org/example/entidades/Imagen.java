package org.example.entidades;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "imagen")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Imagen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;
}
