package com.javabasics.unidad2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class PuntoTest {

    private final double X = 3;
    private final double Y = 4;

    @Test
    void shouldCreatePuntoOrigen() {
        Punto punto = new Punto();

        assertThat(punto.getX(), is(0.0));
        assertThat(punto.getY(), is(0.0));
    }

    @Test
    void shouldCreatePunto() {
        Punto punto = new Punto(X, Y);

        assertThat(punto.getX(), is(X));
        assertThat(punto.getY(), is(Y));
    }

    @Test
    void shouldReturnDistancia() {
        Punto punto = new Punto();

        assertThat(punto.distanciaA(new Punto(X, Y)), is(5.0));
    }

    @Test
    void shouldDesplazarPunto() {
        Punto punto = new Punto();
        punto.desplazar(X, Y);

        assertThat(punto.getY(), is(Y));
        assertThat(punto.getX(), is(X));
    }

    @Test
    void shouldReturnCoordenadas() {
        Punto punto = new Punto(X, Y);

        assertThat(punto.coordenadas(), is("(" + X + ", " + Y + ")"));
    }
}