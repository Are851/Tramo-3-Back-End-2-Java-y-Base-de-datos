/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Electrodomestico;
import Entidad.Lavadora;
import Guia12Ejercicio3.Televisor;
import java.util.ArrayList;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

public class Main {
    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora();


        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
        electrodomesticos.add(new Lavadora(40, 1500, "Blanco", 'B', 50));
        electrodomesticos.add(new Televisor(50, true, 3000, "Negro", 'A', 30));
        electrodomesticos.add(new Lavadora(20, 800, "Gris", 'C', 25));
        electrodomesticos.add(new Televisor(60, false, 2000, "Rojo", 'D', 35));

        double precioTotal = 0;
        double precioLavadoras = 0;
        double precioTelevisores = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            double precioFinal = electrodomestico.precioFinal();
            precioTotal += precioFinal;

            if (electrodomestico instanceof Lavadora) {
                precioLavadoras += precioFinal;
            } else if (electrodomestico instanceof Televisor) {
                precioTelevisores += precioFinal;
            }
        }
        for (Electrodomestico electrodomestico : electrodomesticos) {
            System.out.println("Color "+electrodomestico.getColor()+
                    " ConsumoEnergetico "+
                    electrodomestico.getConsumoEnergetico()+" Peso "
                    +electrodomestico.getPeso()+" precioFinal "+electrodomestico.precioFinal());
            
        }

        System.out.println("Precio de las lavadoras: " + precioLavadoras);
        System.out.println("Precio de los televisores: " + precioTelevisores);
        System.out.println("Precio total de los electrodomésticos: " + precioTotal);
    }
}