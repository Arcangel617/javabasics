package com.javabasics.unidad2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class AlumnoTest {

    private final int LU = 11222;
    private final String NOMBRE = "NOMBRE";
    private final String APELLIDO = "APELLIDO";

    @Test
    void shouldCreateAlumnoWithLUApellidoAndNombre() {
        Alumno alumno = Alumno.builder()
                .lu(LU).nombre(NOMBRE).apellido(APELLIDO)
                .nota1(10).nota2(10)
                .build();

        assertThat(alumno.getLu(), is(LU));
        assertThat(alumno.getNombre(), is(NOMBRE));
        assertThat(alumno.getApellido(), is(APELLIDO));
        assertThat(alumno.getNota1(), is(10.0));
        assertThat(alumno.getNota2(), is(10.0));
    }

    @Test
    void shouldReturnPromedio() {
        Alumno alumno = Alumno.builder().nota1(10).nota2(8).build();

        assertThat(alumno.promedio(), is(9.0));
    }

    @Test
    void shouldReturnNomYApe() {
        Alumno alumno = Alumno.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(alumno.nomYape(), is(NOMBRE + " " + APELLIDO));
    }

    @Test
    void shouldReturnApeYNom() {
        Alumno alumno = Alumno.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(alumno.apeYnom(), is(APELLIDO + " " + NOMBRE));
    }

    void shouldReturnLeyendaAprueba(double nota1, double nota2, String leyenda) {
        Alumno alumno = Alumno.builder().nota1(nota1).nota2(nota2).build();

        assertThat(alumno.leyendaAprueba(), is(leyenda));
    }
}
