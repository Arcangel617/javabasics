package com.javabasics.unidad2;

import lombok.Getter;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Getter
public class Punto {

    private double x;
    private double y;

    public Punto() {
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanciaA(Punto punto) {
        return sqrt(pow((punto.getX() - x), 2) + pow((punto.getY() - y), 2));
    }

    public void desplazar(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String coordenadas() {
        return "(" + x + ", " + y + ")";
    }
}
