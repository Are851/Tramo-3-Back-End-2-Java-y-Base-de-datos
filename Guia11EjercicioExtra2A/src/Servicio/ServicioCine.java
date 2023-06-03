/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Cine;
import entidad.Espectador;
import entidad.Pelicula;
import entidad.Asiento;
import java.util.Random;

public class ServicioCine {

    public void sentarEspectadores(Espectador[] espectadores, Cine cine) {
        Pelicula pelicula = cine.getPelicula();
        Asiento[][] sala = cine.getSala().getAsientos();
        double precioEntrada = cine.getPrecioEntrada();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis()); // Establecer la semilla inicial basada en el tiempo actual
        for (Espectador espectador : espectadores) {
            if (espectador.getEdad() >= pelicula.getEdadMinima() && espectador.getDinero() >= precioEntrada) {
                int fila, columna;
                do {
                    fila = random.nextInt(sala.length);
                    columna = random.nextInt(sala[0].length);
                } while (sala[fila][columna].isOcupado());

                sala[fila][columna].setOcupado(true);
                sala[fila][columna].setEspectador(espectador);
                espectador.setDinero(espectador.getDinero() - precioEntrada);
            }
        }
    }

    public void mostrarSala(Cine cine) {
        Asiento[][] sala = cine.getSala().getAsientos();
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                if (sala[i][j].isOcupado()) {
                    System.out.print("X | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
        }
    }
}
