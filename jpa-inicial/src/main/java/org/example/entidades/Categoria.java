package org.example.entidades;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor

@Builder
@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos = new ArrayList<>();


    @Builder
    public Categoria(Long id, String denominacion, List<Articulo> articulos) {
        this.id = id;
        this.denominacion = denominacion;
        this.articulos = (articulos != null) ? articulos : new ArrayList<>();
    }

}
