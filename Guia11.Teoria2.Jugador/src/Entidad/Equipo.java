/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
import java.util.ArrayList;

public class Equipo {
    private final ArrayList<Jugador> jugadores;

public Equipo() {
    this.jugadores = new ArrayList<>();
}


    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
