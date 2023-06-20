/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia11ejercicio3b;

import java.util.Scanner;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Guia11Ejercicio3B {

public static void main(String[] args) {
        Baraja baraja = new Baraja();
        baraja.crearBaraja();
        Scanner scr = new Scanner(System.in);
        
        int opc;
        System.out.println("  >  Baraja de cartas españolas  <");
        do {
            System.out.println("\nSeleccione accion: ");
            System.out.print("· 1: Barajar cartas\n"
                    + "· 2: Dar la carta siguiente en el mazo\n"
                    + "· 3: Ver cantidad de cartas disponibles\n"
                    + "· 4: Dar n cantidad de cartas\n"
                    + "· 5: Ver cartas repartidas\n"
                    + "· 6: Mostrar la baraja\n"
                    + "· 0: Salir \n"
                    + "  >> ");
            
            opc = scr.nextInt(); 
            switch (opc) {
                case 1:
                    baraja.barajar();
                    break;
                case 2:
                    baraja.siguienteCarta();
                    break;
                case 3:
                    baraja.cartasDisponibles();
                    break;
                case 4:
                    baraja.darCartas();
                    break;
                case 5:
                    baraja.cartasMonton();
                    break;
                case 6:
                    baraja.mostrarBaraja();
                    break;
                case 0:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("Opcion no valida!");
            }
            
        } while (opc != 0);
    }
}