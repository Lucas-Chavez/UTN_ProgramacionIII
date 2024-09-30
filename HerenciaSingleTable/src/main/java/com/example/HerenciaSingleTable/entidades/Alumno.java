package com.example.HerenciaSingleTable.entidades;

import com.example.HerenciaSingleTable.enumeraciones.Especialidad;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@DiscriminatorValue("A")

@EqualsAndHashCode(callSuper = true)

public class Alumno extends Persona{
    private int legajo;
    private Especialidad especialidad;

    @Builder

    public Alumno(String nombre, String apellido, int edad, int legajo, Especialidad especialidad) {
        super(nombre, apellido, edad);
        this.legajo = legajo;
        this.especialidad = especialidad;
    }
}
