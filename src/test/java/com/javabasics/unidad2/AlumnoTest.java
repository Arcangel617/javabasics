package com.javabasics.unidad2;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(ZohhakRunner.class)
public class AlumnoTest {

    private final int LU = 11222;
    private final String NOMBRE = "NOMBRE";
    private final String APELLIDO = "APELLIDO";

    @Test
    public void shouldCreateAlumnoWithLUApellidoAndNombre() {
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
    public void shouldReturnPromedio() {
        Alumno alumno = Alumno.builder().nota1(10).nota2(8).build();

        assertThat(alumno.promedio(), is(9.0));
    }

    @Test
    public void shouldReturnNomYApe() {
        Alumno alumno = Alumno.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(alumno.nomYape(), is(NOMBRE + " " + APELLIDO));
    }

    @Test
    public void shouldReturnApeYNom() {
        Alumno alumno = Alumno.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(alumno.apeYnom(), is(APELLIDO + " " + NOMBRE));
    }

    @TestWith({
            "5, 5, DESAPROBADO",
            "6, 6, APROBADO",
            "6, 4, DESAPROBADO",
            "7, 8, APROBADO"
    })
    public void shouldReturnLeyendaAprueba(double nota1, double nota2, String leyenda) {
        Alumno alumno = Alumno.builder().nota1(nota1).nota2(nota2).build();

        assertThat(alumno.leyendaAprueba(), is(leyenda));
    }
}
