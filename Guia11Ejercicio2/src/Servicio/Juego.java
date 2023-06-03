/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private RevolverDeAgua revolver;

    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverDeAgua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }

    public void ronda() {
        while (true) {
            for (Jugador jugador : jugadores) {
                if (jugador.disparo(revolver)) {
                    System.out.println("¡" + jugador + " se ha mojado! Fin del juego.");
                    return;
                }
            }
        }
    }
}