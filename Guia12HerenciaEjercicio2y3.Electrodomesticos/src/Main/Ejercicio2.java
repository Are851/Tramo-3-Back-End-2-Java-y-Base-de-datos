/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Lavadora;
import Entidad.Televisor;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora();
        lavadora.crearLavadora();
        double precioFinalLavadora = lavadora.precioFinal();
        System.out.println("Valores de la Lavadora:");
        System.out.println("Precio: " + lavadora.getPrecio());
        System.out.println("Color: " + lavadora.getColor());
        System.out.println("Consumo energético: " + lavadora.getConsumoEnergetico());
        System.out.println("Peso: " + lavadora.getPeso());
        System.out.println("Carga: " + lavadora.getCarga());

        Televisor televisor = new Televisor();
        televisor.crearTelevisor();
        double precioFinalTelevisor = televisor.precioFinal();
        System.out.println("Valores del Televisor:");
        System.out.println("Precio: " + televisor.getPrecio());
        System.out.println("Color: " + televisor.getColor());
        System.out.println("Consumo energético: " + televisor.getConsumoEnergetico());
        System.out.println("Peso: " + televisor.getPeso());
        System.out.println("Resolución: " + televisor.getResolucion());
        System.out.println("Sintonizador TDT: " + televisor.isSintonizadorTDT());
    }
}

