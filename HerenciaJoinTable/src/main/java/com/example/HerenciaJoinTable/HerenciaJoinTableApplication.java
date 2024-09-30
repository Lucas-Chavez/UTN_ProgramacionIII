package com.example.HerenciaJoinTable;

import com.example.HerenciaJoinTable.entidades.Alumno;
import com.example.HerenciaJoinTable.entidades.Profesor;
import com.example.HerenciaJoinTable.enumeraciones.Especialidad;
import com.example.HerenciaJoinTable.enumeraciones.Titulos;
import com.example.HerenciaJoinTable.repositorios.AlumnoRepository;
import com.example.HerenciaJoinTable.repositorios.PersonaRepository;
import com.example.HerenciaJoinTable.repositorios.ProfesorRepository;
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
		System.out.println("Join Table");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository, ProfesorRepository profesorRepository, AlumnoRepository alumnoRepository){
		return args -> {
			System.out.println("Funcionando");

			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			BigDecimal sueldo1 = new BigDecimal("6200");
			String fechaString = "2021-09-15";
			Date fecha = formatoFecha.parse(fechaString);

			Profesor profesor = Profesor.builder()
					.nombre("Julian")
					.apellido("Martinez")
					.edad(35)
					.cantidadHijos(3)
					.fechaIngreso(fecha)
					.sueldo(sueldo1)
					.titulo(Titulos.TECNICO)
					.build();

			profesorRepository.save(profesor);

			Alumno alumno = Alumno.builder()
					.nombre("Valentina")
					.apellido("Gomez")
					.edad(22)
					.legajo(45789)
					.especialidad(Especialidad.BACHILLER)
					.build();

			alumnoRepository.save(alumno);
		};
	}

}
