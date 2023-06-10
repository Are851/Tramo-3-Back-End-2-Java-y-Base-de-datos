/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *  <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Televisor extends Electrodomestico {
    private int resolucion;
    private boolean sintonizadorTDT;

    public Televisor() {
        super();
        this.resolucion = 32;
        this.sintonizadorTDT = false;
    }

    public Televisor(double precio, String color, char consumoEnergetico, double peso, int resolucion, boolean sintonizadorTDT) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
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
        // Solicitar información adicional al usuario y llenar los atributos resolucion y sintonizadorTDT
        // Aquí puedes implementar tu código para solicitar los datos al usuario
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal += precioFinal * 0.3;
        }

        if (sintonizadorTDT) {
            precioFinal += 500;
        }

        return precioFinal;
    }
    }