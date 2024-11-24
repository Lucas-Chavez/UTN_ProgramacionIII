package com.example.herencia.entidades;

import lombok.*;
import jakarta.persistence.*;

@Entity
//me creará la tabla Persona con un campo diferenciador
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "diferenciador")

//no utilizar builder en una clase abstracta
@AllArgsConstructor
@NoArgsConstructor


@Table(name = "Persona") //se tiene que llamar igual que la clase
public abstract class Persona extends BaseEntidad{

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    protected int edad;


}
