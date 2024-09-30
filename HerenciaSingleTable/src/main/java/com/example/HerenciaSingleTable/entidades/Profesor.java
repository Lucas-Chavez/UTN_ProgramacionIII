package com.example.HerenciaSingleTable.entidades;

import com.example.HerenciaSingleTable.enumeraciones.Titulos;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

@DiscriminatorValue("P")

@EqualsAndHashCode(callSuper = true)
public class Profesor extends Persona{
    @NotNull
    @Column(name = "cant_hijos")
    private int cantidadHijos;

    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @NotNull
    @Column(name = "sueldo", precision = 10, scale = 2)
    private BigDecimal sueldo;

    private Titulos titulo;

    @Builder
    public Profesor(String nombre, String apellido, int edad, int cantidadHijos, Date fechaIngreso, BigDecimal sueldo, Titulos titulo) {
        super(nombre, apellido, edad);
        this.cantidadHijos = cantidadHijos;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
        this.titulo = titulo;
    }
}