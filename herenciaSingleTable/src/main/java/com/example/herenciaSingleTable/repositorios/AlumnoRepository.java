package com.example.herenciaSingleTable.repositorios;


import com.example.herenciaSingleTable.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
