package com.example.herencia.repositorios;

import com.example.herencia.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
