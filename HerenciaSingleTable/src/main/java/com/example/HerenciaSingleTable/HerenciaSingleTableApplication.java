package com.example.HerenciaSingleTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.HerenciaSingleTable.repositorios.*;
import com.example.HerenciaSingleTable.enumeraciones.*;
import com.example.HerenciaSingleTable.entidades.*;
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
			BigDecimal sueldo1 = new BigDecimal("6350");
			String fechaString = "2022-05-20";
			Date fecha = formatoFecha.parse(fechaString);

			Profesor profesor = Profesor.builder()
					.nombre("Matias")
					.apellido("Rojas")
					.edad(32)
					.cantidadHijos(2)
					.fechaIngreso(fecha)
					.sueldo(sueldo1)
					.titulo(Titulos.LICENCIADO)
					.build();

			profesorRepository.save(profesor);

			Alumno alumno = Alumno.builder()
					.nombre("Sofia")
					.apellido("Fernandez")
					.edad(23)
					.legajo(38762)
					.especialidad(Especialidad.PERITO_MERCANTIL)
					.build();

			alumnoRepository.save(alumno);
		};
	}

}
