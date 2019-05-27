package com.javabasics.unidad2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PuntoTest {

    private final double X = 3;
    private final double Y = 4;

    @Test
    public void shouldCreatePuntoOrigen() {
        Punto punto = new Punto();

        assertThat(punto.getX(), is(0.0));
        assertThat(punto.getY(), is(0.0));
    }

    @Test
    public void shouldCreatePunto() {
        Punto punto = new Punto(X, Y);

        assertThat(punto.getX(), is(X));
        assertThat(punto.getY(), is(Y));
    }

    @Test
    public void shouldReturnDistancia() {
        Punto punto = new Punto();

        assertThat(punto.distanciaA(new Punto(X, Y)), is(5.0));
    }

    @Test
    public void shouldDesplazarPunto() {
        Punto punto = new Punto();
        punto.desplazar(X, Y);

        assertThat(punto.getY(), is(Y));
        assertThat(punto.getX(), is(X));
    }

    @Test
    public void shouldReturnCoordenadas() {
        Punto punto = new Punto(X, Y);

        assertThat(punto.coordenadas(), is("(" + X + ", " + Y + ")"));
    }
}