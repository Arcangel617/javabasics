package com.javabasics.unidad2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

    private Cliente cliente;

    private final int NRO_DNI = 11222333;
    private final String APELLIDO = "APELLIDO";
    private final String NOMBRE = "NOMBRE";
    private final double SALDO = 1000;

    @BeforeEach
    void setUp() {
        cliente = Cliente.builder()
                .nroDni(NRO_DNI)
                .apellido(APELLIDO)
                .nombre(NOMBRE)
                .saldo(SALDO)
                .build();
    }

    @Test
    void shouldCreateClienteWithAllParameters() {
        assertThat(cliente.getNroDni(), is(NRO_DNI));
        assertThat(cliente.getApellido(), is(APELLIDO));
        assertThat(cliente.getNombre(), is(NOMBRE));
        assertThat(cliente.getSaldo(), is(SALDO));
    }

    @Test
    void shouldReturnLastNameAndFirstName() {
        assertThat(cliente.apeYnom(), is(APELLIDO + " " + NOMBRE));
    }

    @Test
    void shouldReturnFirstNameAndLastName() {
        assertThat(cliente.nomYape(), is(NOMBRE + " " + APELLIDO));
    }

    @Test
    void shouldReturnNuevoSaldo() {
        cliente.nuevoSaldo(2000);
        assertThat(cliente.getSaldo(), is(2000.0));
    }

    @Test
    void shouldReturnSaldoActualizado() {
        cliente.agregaSaldo(2000);
        assertThat(cliente.getSaldo(), is(3000.0));
    }
}