package com.javabasics.unidad2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClienteTest {

    private Cliente cliente;

    private final int NRO_DNI = 11222333;
    private final String APELLIDO = "APELLIDO";
    private final String NOMBRE = "NOMBRE";
    private final double SALDO = 1000;

    @Before
    public void setUp() {
        cliente = Cliente.builder()
                .nroDni(NRO_DNI)
                .apellido(APELLIDO)
                .nombre(NOMBRE)
                .saldo(SALDO)
                .build();
    }

    @Test
    public void shouldCreateClienteWithAllParameters() {
        assertThat(cliente.getNroDni(), is(NRO_DNI));
        assertThat(cliente.getApellido(), is(APELLIDO));
        assertThat(cliente.getNombre(), is(NOMBRE));
        assertThat(cliente.getSaldo(), is(SALDO));
    }

    @Test
    public void shouldReturnLastNameAndFirstName() {
        assertThat(cliente.apeYnom(), is(APELLIDO + " " + NOMBRE));
    }

    @Test
    public void shouldReturnFirstNameAndLastName() {
        assertThat(cliente.nomYape(), is(NOMBRE + " " + APELLIDO));
    }

    @Test
    public void shouldReturnNuevoSaldo() {
        cliente.nuevoSaldo(2000);
        assertThat(cliente.getSaldo(), is(2000.0));
    }

    @Test
    public void shouldReturnSaldoActualizado() {
        cliente.agregaSaldo(2000);
        assertThat(cliente.getSaldo(), is(3000.0));
    }
}