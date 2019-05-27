package com.javabasics.unidad2;

import lombok.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Builder
@AllArgsConstructor
public class Laboratorio {

    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;

    private static final Logger logger = LogManager.getLogger(Laboratorio.class);

    public void mostrar() {
        String message = "Laboratorio: " + nombre + "- Domicilio: " + domicilio + " - Telefono:" + telefono;

        logger.log(Level.DEBUG, message);
    }
}
