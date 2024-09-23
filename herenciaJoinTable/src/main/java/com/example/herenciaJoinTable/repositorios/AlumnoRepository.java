package com.example.herenciaJoinTable.repositorios;

import com.example.herenciaJoinTable.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
