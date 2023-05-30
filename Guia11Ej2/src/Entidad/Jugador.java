package Entidad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Jugador {
    private int id;
    private String nombre;
    private boolean mojado;

    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.mojado = false;
    }

    public boolean disparo(RevolverDeAgua revolver) {
        revolver.siguienteChorro();
        if (revolver.mojar()) {
            mojado = true;
            return true;
        }
        return false;
    }

    public boolean estaMojado() {
        return mojado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}