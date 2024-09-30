package com.example.HerenciaJoinTable.repositorios;

import com.example.HerenciaJoinTable.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
