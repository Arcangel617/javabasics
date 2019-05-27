package com.javabasics.unidad2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class Persona {

    private int nroDni;
    private String nombre;
    private String apellido;
    private int anioNacimiento;

    private static final Logger logger = LogManager.getLogger(Persona.class);

    public int edad() {
        return LocalDate.now().getYear() - anioNacimiento;
    }

    public String nomYApe() {
        return nombre + " " + apellido;
    }

    public String apeYNom() {
        return apellido + " " + nombre;
    }

    public void mostrar() {
        String message = "Nombre y Apellido: " + nomYApe() + " - Dni: " + nroDni + " - Edad: " + edad();

        logger.log(Level.DEBUG, message);
    }
}
