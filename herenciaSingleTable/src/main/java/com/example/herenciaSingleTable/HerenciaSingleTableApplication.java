package com.example.herenciaSingleTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.herenciaSingleTable.repositorios.*;
import com.example.herenciaSingleTable.enumeraciones.*;
import com.example.herenciaSingleTable.entidades.*;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class HerenciaSingleTableApplication {
	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	ProfesorRepository profesorRepository;

	@Autowired
	AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HerenciaSingleTableApplication.class, args);
		System.out.println("Single Table");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository, ProfesorRepository profesorRepository, AlumnoRepository alumnoRepository){
		return args -> {
			System.out.println("Funcionando");

			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			BigDecimal sueldo1 = new BigDecimal("5450");
			String fechaString = "2023-11-30";
			Date fecha = formatoFecha.parse(fechaString);

			Profesor profesor = Profesor.builder()
					.nombre("Lautaro")
					.apellido("Campos")
					.edad(28)
					.cantidadHijos(1)
					.fechaIngreso(fecha)
					.sueldo(sueldo1)
					.titulo(Titulos.INGENIERO)
					.build();

			profesorRepository.save(profesor);

			Alumno alumno = Alumno.builder()
					.nombre("Franco")
					.apellido("Castillo")
					.edad(25)
					.legajo(41555)
					.especialidad(Especialidad.BACHILLER)
					.build();

			alumnoRepository.save(alumno);
		};
	}
}



