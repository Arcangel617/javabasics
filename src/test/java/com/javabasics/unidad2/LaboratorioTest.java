package com.javabasics.unidad2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class LaboratorioTest {

    private final String NOMBRE = "nombre";
    private final String DOMICILIO = "domicilio";
    private final String TELEFONO = "telefono";

    @Test
    void shouldBuildObjectWithoutParamenters() {
        Laboratorio laboratorio = Laboratorio.builder().build();

        assertThat(laboratorio.getNombre(), is(nullValue()));
        assertThat(laboratorio.getDomicilio(), is(nullValue()));
        assertThat(laboratorio.getTelefono(), is(nullValue()));
        assertThat(laboratorio.getCompraMinima(), is(0));
        assertThat(laboratorio.getDiaEntrega(), is(0));
    }

    @Test
    void shouldBuildObjectWithNombreDomicilioAndTelefono() {
        Laboratorio laboratorio = Laboratorio.builder()
                .nombre(NOMBRE)
                .domicilio(DOMICILIO)
                .telefono(TELEFONO)
                .build();

        assertThat(laboratorio.getNombre(), is(NOMBRE));
        assertThat(laboratorio.getDomicilio(), is(DOMICILIO));
        assertThat(laboratorio.getTelefono(), is(TELEFONO));
        assertThat(laboratorio.getCompraMinima(), is(0));
        assertThat(laboratorio.getDiaEntrega(), is(0));
    }

    @Test
    void shouldBuildObjectWithNombreAndDomicilio() {
        Laboratorio laboratorio = Laboratorio.builder()
                .nombre(NOMBRE)
                .domicilio(DOMICILIO)
                .build();

        assertThat(laboratorio.getNombre(), is(NOMBRE));
        assertThat(laboratorio.getDomicilio(), is(DOMICILIO));
        assertThat(laboratorio.getTelefono(), is(nullValue()));
        assertThat(laboratorio.getCompraMinima(), is(0));
        assertThat(laboratorio.getDiaEntrega(), is(0));
    }

    @Test
    void shouldBuildObjectWithNombre() {
        Laboratorio laboratorio = Laboratorio.builder()
                .nombre(NOMBRE)
                .build();

        assertThat(laboratorio.getNombre(), is(NOMBRE));
        assertThat(laboratorio.getDomicilio(), is(nullValue()));
        assertThat(laboratorio.getTelefono(), is(nullValue()));
        assertThat(laboratorio.getCompraMinima(), is(0));
        assertThat(laboratorio.getDiaEntrega(), is(0));
    }
}