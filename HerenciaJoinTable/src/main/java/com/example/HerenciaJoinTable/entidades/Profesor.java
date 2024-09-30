package com.example.HerenciaJoinTable.entidades;

import com.example.HerenciaJoinTable.enumeraciones.Titulos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

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