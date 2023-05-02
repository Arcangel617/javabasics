package com.javabasics.unidad3;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class ProductoTest {

    private final int CODIGO = 1;
    private final String RUBRO = "Perfumeria";
    private final String DESCRIPCION = "Jabon Deluxe";
    private final double COSTO = 100.0;
    private final int STOCK = 100;
    private final double PORC_PTO_REPO = 12.0;
    private final int EXIST_MINIMA = 10;

    @Test
    void shouldCreateProducto() {
        Producto producto = Producto.builder().codigo(CODIGO).
                rubro(RUBRO).descripcion(DESCRIPCION).costo(COSTO).
                stock(STOCK).porcPtoRepo(PORC_PTO_REPO).existMinima(EXIST_MINIMA).
                build();

        assertThat(producto.getCodigo(), is(CODIGO));
        assertThat(producto.getRubro(), is(RUBRO));
        assertThat(producto.getDescripcion(), is(DESCRIPCION));
        assertThat(producto.getCosto(), is(COSTO));
        assertThat(producto.getStock(), is(STOCK));
        assertThat(producto.getPorcPtoRepo(), is(PORC_PTO_REPO));
        assertThat(producto.getExistMinima(), is(EXIST_MINIMA));
    }

    @Test
    void shouldReturnPrecioLista() {

    }

    void shouldUpdateStock(int cantidad) {
        Producto producto = Producto.builder().stock(STOCK).build();
        producto.ajuste(cantidad);
        assertThat(producto.getStock(), is(STOCK + cantidad));
    }

    @Test
    void shouldReturnStockValorizado() {

    }

    @Test
    void shouldReturnPrecioContado() {

    }

    @Test
    void shouldMostrarLinea() {

    }
}