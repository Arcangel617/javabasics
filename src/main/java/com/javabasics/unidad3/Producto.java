package com.javabasics.unidad3;

import com.javabasics.unidad2.Laboratorio;
import lombok.Builder;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Builder
public class Producto {

    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    private static final Logger logger = LogManager.getLogger(Producto.class);

    public void mostrar() {
        //TODO improve implentation for logging. I might need to override the toString() method on each class.
    }

    public void ajuste(int cantidad) {
        this.stock = this.stock + cantidad;
    }

    public double sotckValorizado() {
        double rentabilidad = (this.costo * this.stock) * 0.12;
        return this.costo * this.stock + rentabilidad;
    }

    public double precioLista() {
        double ajuste = this.costo * 0.12;
        return this.costo + ajuste;
    }

    public double precioContado() {
        double ajuste = precioLista() * 0.05;
        return precioLista() - ajuste;
    }

    public String mostrarLinea() {
        return descripcion + " " + precioLista() + " " + precioContado();
    }
}
