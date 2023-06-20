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
import java.util.List;

class Equipo {
    private List<Jugador> jugadores;

    public Equipo() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
