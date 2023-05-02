package com.javabasics.unidad2;

import static com.javabasics.javabasicsutils.Constants.CURRENT_YEAR;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class EmpleadoTest {

    private final long CUIL = 2011222333;
    private final String APELLIDO = "APELLIDO";
    private final String NOMBRE = "NOMBRE";
    private final double SUELDO_BASICO = 1000;
    private final int ANIO_INGRESO = 2019;
    
    @InjectMocks
    private Empleado empleado;

    @Test
    void shouldBuildAnEmpleado() {
        empleado = Empleado.builder().cuil(CUIL).apellido(APELLIDO).nombre(NOMBRE).sueldoBasico(SUELDO_BASICO).anioIngreso(ANIO_INGRESO).build();

        assertThat(empleado.getCuil(), is(CUIL));
        assertThat(empleado.getApellido(), is(APELLIDO));
        assertThat(empleado.getNombre(), is(NOMBRE));
        assertThat(empleado.getSueldoBasico(), is(SUELDO_BASICO));
        assertThat(empleado.getAnioIngreso(), is(ANIO_INGRESO));
    }

    @Test
    void shouldReturnAntiguedad() {
        empleado = Empleado.builder().anioIngreso(ANIO_INGRESO).build();

        assertThat(empleado.antiguedad(), is(CURRENT_YEAR - ANIO_INGRESO));
    }

    @Test
    void shouldApplyDiscount() {
        empleado = Empleado.builder().sueldoBasico(1000).build();

        assertThat(empleado.descuento(), is(212.0));
    }

    void shouldApplyAdicional(int antiguedad, double adicional) {
        empleado = Empleado.builder().sueldoBasico(SUELDO_BASICO).anioIngreso(CURRENT_YEAR - antiguedad).build();

        assertThat(empleado.adicional(), is(adicional));
    }

    void shouldReturnSueldoNeto(int antiguedad, double sueldoNeto) {
        empleado = Empleado.builder().sueldoBasico(SUELDO_BASICO).anioIngreso(CURRENT_YEAR - antiguedad).build();

        assertThat(empleado.sueldoNeto(), is(sueldoNeto));
    }

    @Test
    void shouldReturnNomYApe() {
        empleado = Empleado.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(empleado.nomYApe(), is(NOMBRE + " " + APELLIDO));
    }

    @Test
    void shouldReturnApeYNom() {
        empleado = Empleado.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(empleado.apeYNom(), is(APELLIDO + " " + NOMBRE));
    }
}