package com.javabasics.unidad2;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.javabasics.javabasicsutils.Constants.CURRENT_YEAR;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(ZohhakRunner.class)
public class EmpleadoTest {

    private final long CUIL = 2011222333;
    private final String APELLIDO = "APELLIDO";
    private final String NOMBRE = "NOMBRE";
    private final double SUELDO_BASICO = 1000;
    private final int ANIO_INGRESO = 2019;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldBuildAnEmpleado() {
        Empleado empleado = Empleado.builder().cuil(CUIL).apellido(APELLIDO).nombre(NOMBRE).sueldoBasico(SUELDO_BASICO).anioIngreso(ANIO_INGRESO).build();

        assertThat(empleado.getCuil(), is(CUIL));
        assertThat(empleado.getApellido(), is(APELLIDO));
        assertThat(empleado.getNombre(), is(NOMBRE));
        assertThat(empleado.getSueldoBasico(), is(SUELDO_BASICO));
        assertThat(empleado.getAnioIngreso(), is(ANIO_INGRESO));
    }

    @Test
    public void shouldReturnAntiguedad() {
        Empleado empleado = Empleado.builder().anioIngreso(ANIO_INGRESO).build();

        assertThat(empleado.antiguedad(), is(CURRENT_YEAR - ANIO_INGRESO));
    }

    @Test
    public void shouldApplyDiscount() {
        Empleado empleado = Empleado.builder().sueldoBasico(1000).build();

        assertThat(empleado.descuento(), is(212.0));
    }

    @TestWith({
            "1,  200.0",
            "2,  400.0",
            "9,  400.0",
            "10, 600.0",
            "11, 600.0"
    })
    public void shouldApplyAdicional(int antiguedad, double adicional) {
        Empleado empleado = Empleado.builder().sueldoBasico(SUELDO_BASICO).anioIngreso(CURRENT_YEAR - antiguedad).build();

        assertThat(empleado.adicional(), is(adicional));
    }

    @TestWith({
            "1,  988.0",
            "2,  1188.0",
            "9,  1188.0",
            "10, 1388.0",
            "11, 1388.0"
    })
    public void shouldReturnSueldoNeto(int antiguedad, double sueldoNeto) {
        Empleado empleado = Empleado.builder().sueldoBasico(SUELDO_BASICO).anioIngreso(CURRENT_YEAR - antiguedad).build();

        assertThat(empleado.sueldoNeto(), is(sueldoNeto));
    }

    @Test
    public void shouldReturnNomYApe() {
        Empleado empleado = Empleado.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(empleado.nomYApe(), is(NOMBRE + " " + APELLIDO));
    }

    @Test
    public void shouldReturnApeYNom() {
        Empleado empleado = Empleado.builder().nombre(NOMBRE).apellido(APELLIDO).build();

        assertThat(empleado.apeYNom(), is(APELLIDO + " " + NOMBRE));
    }
}