package com.javabasics.unidad2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {

    private final int nroDni = 1122334455;
    private final String nombre = "NOMBRE";
    private final String apellido = "APELLIDO";
    private final int anioNacimiento = 1989;

    private Persona persona;

    @BeforeEach
    void setUp() {
        persona = Persona.builder()
                .nroDni(nroDni)
                .nombre(nombre)
                .apellido(apellido)
                .anioNacimiento(anioNacimiento)
                .build();
    }

    @Test
    void shouldCreateAPersonWithAllParameters() {
        assertThat(persona.getNroDni(), is(nroDni));
        assertThat(persona.getNombre(), is(nombre));
        assertThat(persona.getApellido(), is(apellido));
        assertThat(persona.getAnioNacimiento(), is(anioNacimiento));
    }

    @Test
    void shouldReturnLastNameAndFirstName() {
        assertThat(persona.apeYNom(), is(apellido + " " + nombre));
    }

    @Test
    void shouldReturnFirstNameAndLastName() {
        assertThat(persona.nomYApe(), is(nombre + " " + apellido));
    }

    @Test
    void shouldReturnEdad() {
        assertThat(persona.edad(), is(34));
    }
}
