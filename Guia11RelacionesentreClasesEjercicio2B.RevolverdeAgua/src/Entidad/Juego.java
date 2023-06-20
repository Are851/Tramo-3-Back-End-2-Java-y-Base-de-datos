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
import java.util.Iterator;
import java.util.Scanner;

public class Juego {

    Scanner leer = new Scanner(System.in);

    private ArrayList<Jugador> jugadores;
    private Revolver rev;

    public Juego() {
        this.rev = new Revolver();
        this.jugadores = new ArrayList<>();
    }

    public Juego(ArrayList<Jugador> jugadores, Revolver rev) {
        this.jugadores = jugadores;
        this.rev = rev;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Revolver getRev() {
        return rev;
    }

    public void setRev(Revolver rev) {
        this.rev = rev;
    }

    public void llenarJuego(ArrayList<Jugador> jugadores, Revolver r) {
        System.out.println("Ingrese la cantidad de jugadores (máximo 6): ");
        int cantJugadores = leer.nextInt();
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        r.llenarRevolver();

        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Ingrese el ID del jugador: ");
            int id = leer.nextInt();
            System.out.println("Ingrese el nombre del jugador: ");
            String nombre = leer.next();
            Jugador jugador = new Jugador(id, nombre, false);
            listaJugadores.add(jugador);
        }

        jugadores.addAll(listaJugadores);
        
        System.out.println("Lista de jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println("ID: " + jugador.getId() + ", Nombre: " + jugador.getNombre());
        }

    }



public void ronda() {
        llenarJuego(jugadores, rev);

        Iterator<Jugador> it = jugadores.iterator();

        while (it.hasNext()) {
            Jugador jugador = it.next();
            boolean disparo = jugador.disparo(rev);

            if (disparo) {
                System.out.println("El jugador " + jugador.getNombre() + " se ha mojado.");
                break;
            } else {
                System.out.println("El jugador " + jugador.getNombre() + " no se ha mojado.");
            }
        }
    }
}
