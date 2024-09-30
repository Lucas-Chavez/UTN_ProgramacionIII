package com.example.HerenciaJoinTable.repositorios;

import com.example.HerenciaJoinTable.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}