/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
import Entidad.Equipo;
import Entidad.Jugador;
import java.util.Scanner;

public class ServiciosEquipos {

    Scanner leer = new Scanner(System.in).useDelimiter("\\n");
    Equipo equipo;

    public void crearJugador() {
        String confirmacion;
        System.out.print("Ingrese los datos del Jugador: ");

        do {
            Jugador jugador = new Jugador();

            System.out.print("Ingrese Nombre: ");
            jugador.setNombre(leer.next());

            System.out.print("Ingrese Apellido: ");
            jugador.setApellido(leer.next());

            System.out.print("Ingrese Posicion: ");
            jugador.setPosicion(leer.next());

            System.out.print("Ingrese Numero: ");
            jugador.setNumero(leer.nextInt());

            equipo.agregarJugador(jugador);
            System.out.print("Para salir oprima (S): ");
            confirmacion = leer.next();

        } while (!confirmacion.equalsIgnoreCase("s"));
    }

    public void mostrar() {
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.println(jugador);
        }
    }
}
