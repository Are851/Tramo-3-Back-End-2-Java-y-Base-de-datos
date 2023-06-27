/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia12Ejercicio3;

import Entidad.Electrodomestico;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */    

public class Televisor extends Electrodomestico {
    private double resolucion;
    private boolean sintonizadorTDT;

    public Televisor() {
        super();
        this.resolucion = 0;
        this.sintonizadorTDT = false;
    }

    public Televisor(double resolucion, boolean sintonizadorTDT, double precio, String color, char consumoEnergetico, double peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public double getResolucion() {
        return resolucion;
    }

    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public void crearTelevisor() {
        crearElectrodomestico();
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal *= 1.3;
        }

        if (sintonizadorTDT) {
            precioFinal += 500;
        }

        return precioFinal;
    }
}



