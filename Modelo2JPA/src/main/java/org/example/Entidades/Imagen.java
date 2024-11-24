package org.example.Entidades;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "imagenes")

public class Imagen implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String denominacion;

}
