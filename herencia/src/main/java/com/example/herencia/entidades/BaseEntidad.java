package com.example.herencia.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import java.io.Serializable;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor



public class BaseEntidad implements Serializable{
        @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;


}
