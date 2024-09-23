package com.example.herenciaJoinTable.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@NoArgsConstructor
@AllArgsConstructor

@Table(name = "persona")
public abstract class Persona extends BaseEntidad{
    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    protected int edad;
}
