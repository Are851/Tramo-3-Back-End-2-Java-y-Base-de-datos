/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
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