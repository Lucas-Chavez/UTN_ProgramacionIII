package com.example.herenciaJoinTable;

import com.example.herenciaJoinTable.entidades.Alumno;
import com.example.herenciaJoinTable.entidades.Profesor;
import com.example.herenciaJoinTable.enumeraciones.Especialidad;
import com.example.herenciaJoinTable.enumeraciones.Titulos;
import com.example.herenciaJoinTable.repositorios.AlumnoRepository;
import com.example.herenciaJoinTable.repositorios.PersonaRepository;
import com.example.herenciaJoinTable.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class HerenciaJoinTableApplication {
	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	ProfesorRepository profesorRepository;

	@Autowired
	AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HerenciaJoinTableApplication.class, args);
		System.out.println("Genero Join Table");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository, ProfesorRepository profesorRepository, AlumnoRepository alumnoRepository){
		return args -> {
			System.out.println("----------- FUNCIONANDO ------------");
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			BigDecimal sueldo = new BigDecimal("1654.32");

			String fechaString = "2022-06-21";

			//parseo el string en un Date
			Date fecha = formatoFecha.parse(fechaString);

			Profesor profesor = Profesor.builder()
					.nombre("Carlos")
					.apellido("Perez")
					.edad(55)
					.cantHijos(1)
					.fechaIngreso(fecha)
					.sueldo(sueldo)
					.titulo(Titulos.INGENIERO)
					.build();

			//guardo el profesor creado
			profesorRepository.save(profesor);


			Alumno alumno = Alumno.builder()
					.nombre("Geronimo")
					.apellido("Crescitelli")
					.edad(24)
					.legajo(50601)
					.especialidad(Especialidad.BACHILLER)
					.build();

			//guardo el alumno creado
			alumnoRepository.save(alumno);
		};
	}
}