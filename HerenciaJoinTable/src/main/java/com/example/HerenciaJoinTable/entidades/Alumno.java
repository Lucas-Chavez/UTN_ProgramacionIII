package com.example.HerenciaJoinTable.entidades;

import com.example.HerenciaJoinTable.enumeraciones.Especialidad;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper = true)

@Table(name = "alumno")
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