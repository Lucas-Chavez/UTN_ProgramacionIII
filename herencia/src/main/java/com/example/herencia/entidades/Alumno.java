package com.example.herencia.entidades;

import com.example.herencia.enumeraciones.Especialidad;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

//este es el valor que coloco para diferenciarlo de profesor
@DiscriminatorValue("A")

@EqualsAndHashCode(callSuper = true)

public class Alumno extends Persona{

    private int legajo;

    private Especialidad especialidad;

    @Builder
    public Alumno (String nombre, String apellido, int edad, int legajo, Especialidad especialidad){
        super(nombre, apellido, edad);
        this.legajo = legajo;
        this.especialidad = especialidad;

    }
}
