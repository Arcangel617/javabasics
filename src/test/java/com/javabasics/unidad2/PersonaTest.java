package com.javabasics.unidad2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PersonaTest {

    private Persona persona;

    private final int nroDni = 1122334455;
    private final String nombre = "NOMBRE";
    private final String apellido = "APELLIDO";
    private final int anioNacimiento = 1989;

    @Before
    public void setUp() {
        persona = Persona.builder()
                .nroDni(nroDni)
                .nombre(nombre)
                .apellido(apellido)
                .anioNacimiento(anioNacimiento)
                .build();
    }

    @Test
    public void shouldCreateAPersonWithAllParameters() {
        assertThat(persona.getNroDni(), is(nroDni));
        assertThat(persona.getNombre(), is(nombre));
        assertThat(persona.getApellido(), is(apellido));
        assertThat(persona.getAnioNacimiento(), is(anioNacimiento));
    }

    @Test
    public void shouldReturnLastNameAndFirstName() {
        assertThat(persona.apeYNom(), is(apellido + " " + nombre));
    }

    @Test
    public void shouldReturnFirstNameAndLastName() {
        assertThat(persona.nomYApe(), is(nombre + " " + apellido));
    }

    @Test
    public void shouldReturnEdad() {
        assertThat(persona.edad(), is(30));
    }
}
