package com.javabasics.unidad2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Builder
@AllArgsConstructor
public class Cliente {

    private int nroDni;
    private String apellido;
    private String nombre;
    private double saldo;

    private final Logger logger = LogManager.getLogger(Cliente.class);

    public void mostrar() {
        String message = "- Cliente - Nombre y Apellido: " + nomYape() + "- Saldo: " + saldo;

        logger.log(Level.DEBUG, message);
    }

    public double nuevoSaldo(double importe) {
        saldo = importe;
        return saldo;
    }

    public double agregaSaldo(double importe) {
        saldo = saldo + importe;
        return saldo;
    }

    public String apeYnom() {
        return apellido + " " + nombre;
    }

    public String nomYape() {
        return nombre + " " + apellido;
    }
}
