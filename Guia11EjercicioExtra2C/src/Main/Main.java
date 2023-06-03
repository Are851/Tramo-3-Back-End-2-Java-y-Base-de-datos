/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Cine;
import Entidad.Espectador;
import Entidad.Pelicula;
import Servicio.Servicio;

public class Main {

    public static void main(String[] args) {
        // Crear película
        Pelicula pelicula = new Pelicula("The Matrix", 2.30, 16, "Wachowski Sisters");

        // Crear cine con 8 filas y 6 columnas
        Cine cine = new Cine(pelicula, 10.0, 8, 6);

        // Crear espectadores
        Espectador[] espectadores = new Espectador[50];
        for (int i = 0; i < espectadores.length; i++) {
            String nombre = "Espectador " + (i + 1);
            int edad = (int) (Math.random() * 50 + 1);
            double dinero = Math.random() * 20;
            espectadores[i] = new Espectador(nombre, edad, dinero);
        }

        // Crear instancia del servicio
        Servicio servicio = new Servicio();

        // Sentar espectadores
        servicio.sentarEspectadores(espectadores, cine);

        // Mostrar sala
        servicio.mostrarSala(cine);
    }
}

