package com.javabasics.unidad2;

import lombok.Builder;
import lombok.Getter;

import static com.javabasics.javabasicsutils.Constants.*;

@Getter
@Builder
public class Empleado {

    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;

    public Empleado(long cuil, String apellido, String nombre, double sueldoBasico, int anioIngreso) {
        this.cuil = cuil;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
        this.anioIngreso = anioIngreso;
    }

    public int antiguedad() {
        return CURRENT_YEAR - anioIngreso;
    }

    public double descuento() {
        return sueldoBasico * EMPLEADO_DISCOUNT + 12;
    }

    public double adicional() {
        if (antiguedad() >= 2 && antiguedad() < 10) {
            return sueldoBasico * ADICIONAL_4;
        }

        if (antiguedad() >= 10) {
            return sueldoBasico * ADICIONAL_6;
        }

        return sueldoBasico * ADICIONAL_2;
    }

    public double sueldoNeto() {
        return sueldoBasico + adicional() - descuento();
    }

    public String nomYApe() {
        return nombre + " " + apellido;
    }

    public String apeYNom() {
        return apellido + " " + nombre;
    }
}
