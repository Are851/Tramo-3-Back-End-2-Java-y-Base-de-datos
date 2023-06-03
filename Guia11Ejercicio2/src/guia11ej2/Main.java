/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia11ej2;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import Servicio.Juego;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener el número de jugadores
        System.out.print("Ingrese el número de jugadores (entre 1 y 6): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Validar el número de jugadores
        if (numJugadores < 1 || numJugadores > 6) {
            System.out.println("Número de jugadores inválido. Se utilizarán 6 jugadores por defecto.");
            numJugadores = 6;
        }

        // Crear jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 1; i <= numJugadores; i++) {
            jugadores.add(new Jugador(i));
        }

        // Crear revolver de agua y llenarlo
        RevolverDeAgua revolver = new RevolverDeAgua();
        revolver.llenarRevolver();

        // Crear el juego y llenarlo con los jugadores y el revolver
        Juego juego = new Juego();
        juego.llenarJuego(jugadores, revolver);

        // Iniciar las rondas del juego
        juego.ronda();
    }
}