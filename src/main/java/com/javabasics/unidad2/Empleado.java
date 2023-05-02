package com.javabasics.unidad2;

import com.javabasics.javabasicsutils.Constants;
import lombok.Builder;
import lombok.Getter;

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
        return Constants.CURRENT_YEAR - anioIngreso;
    }

    public double descuento() {
        return sueldoBasico * Constants.EMPLEADO_DISCOUNT + 12;
    }

    public double adicional() {
        if (antiguedad() >= 2 && antiguedad() < 10) {
            return sueldoBasico * Constants.ADICIONAL_4;
        }

        if (antiguedad() >= 10) {
            return sueldoBasico * Constants.ADICIONAL_6;
        }

        return sueldoBasico * Constants.ADICIONAL_2;
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
