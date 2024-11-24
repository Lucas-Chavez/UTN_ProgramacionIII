package org.example.Entidades;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="articulo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString


public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;


    @OneToOne

    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

//    @ManyToMany(mappedBy = "articulos")
//    @Builder.Default
//    private Set<Articulo> promociones = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private UnidadMedida unidadMedida;

}




