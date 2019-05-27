package com.javabasics.unidad2;

import lombok.Builder;
import lombok.Getter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Builder
public class Alumno {

    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;

    private static final Logger logger = LogManager.getLogger(Alumno.class);

    private boolean aprueba() {
        return promedio() > 7 || (nota1 >= 6 && nota2 >= 6);
    }

    public  String leyendaAprueba() {
        return aprueba() ? "APROBADO" : "DESAPROBADO";
    }

    public double promedio() {
        return (nota1 + nota2) / 2;
    }

    public String nomYape() {
        return nombre + " " + apellido;
    }

    public String apeYnom() {
        return apellido + " " + nombre;
    }

    public void mostar() {
        String message = "Nombre y Apellido: "
                + nomYape() + "LU: "
                + lu + "Notas: "
                + nota1 + " - " + nota2
                + "Promedio: " + promedio() + " - " + leyendaAprueba();
        logger.log(Level.DEBUG, message);
    }
}
