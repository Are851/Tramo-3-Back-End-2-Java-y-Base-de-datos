/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia11.teoria2;

import Servicios.ServiciosEquipos;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */

public class Main {

    public static void main(String[] args) {

        ServiciosEquipos se1 = new ServiciosEquipos();

        se1.crearJugador();
        se1.mostrar();
    }
}