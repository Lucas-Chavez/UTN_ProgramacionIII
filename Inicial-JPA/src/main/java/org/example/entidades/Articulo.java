package org.example.entidades;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;
    private double precio;
    private int cantidad;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetalleFactura> detalle = new ArrayList<>();
}
