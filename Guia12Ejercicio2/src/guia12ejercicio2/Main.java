/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia12ejercicio2;

import Entidad.Lavadora;
import Entidad.Televisor;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *  <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Main {
    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora();
        lavadora.crearLavadora();
        double precioFinalLavadora = lavadora.precioFinal();
        System.out.println("Precio final de la lavadora: $" + precioFinalLavadora);

        Televisor televisor = new Televisor();
        televisor.crearTelevisor();
        double precioFinalTelevisor = televisor.precioFinal();
        System.out.println("Precio final del televisor: $" + precioFinalTelevisor);
    }
}
