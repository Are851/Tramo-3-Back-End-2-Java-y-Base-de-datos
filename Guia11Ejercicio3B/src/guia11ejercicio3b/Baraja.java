/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia11ejercicio3b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Baraja {

    private  ArrayList<Carta> baraja = new ArrayList<>();
    private  ArrayList<Carta> RestoBaraja = new ArrayList<>();
    private Carta carta;

    public void crearBaraja() {
        System.out.println("...\n");
        for (int i = 0; i < 4; i++) { //String [i] palos = {"Basto","Espada","Oro","Copa"}
            for (int j = 1; j <= 12; j++) {
                carta = new Carta(); // -
                switch (i) {
                    case 0:
                        carta.setPalo("Espada");
                        break;
                    case 1:
                        carta.setPalo("Oro");
                        break;
                    case 2:
                        carta.setPalo("Copa");
                        break;
                    case 3:
                        carta.setPalo("Basto");
                        break;
                }
                carta.setNumero(j);
                if (j != 8 && j != 9) {
                   baraja.add(carta); //new Carta(j,i[]);
                }
            }
        }
    }

    public void barajar() {
        Collections.shuffle(baraja);
        System.out.println("Mezclando...\t Hecho!");
    }

    public void siguienteCarta() {
        if (baraja.isEmpty()) {
            System.out.println("No quedan cartas!");
        } else {
            for (Carta c : baraja) {
                System.out.println("Su nueva carta es el " + c);
                RestoBaraja.add(c);
                baraja.remove(c);
                break;
            }
        }
    }

    public void cartasDisponibles() {
        int disponibles =  baraja.size();
        System.out.println("Diponibles para repartir: " + disponibles + " cartas.");   
    }

    public void darCartas() {
        Scanner scr = new Scanner(System.in);
        int cantCartas;

        System.out.print("¿Cuantas cartas desea? > ");
        cantCartas = scr.nextInt();

        if (cantCartas > baraja.size()) {
            System.out.println("No hay suficientes cartas.");
        } else {
            System.out.println("Sus nuevas cartas son:\n");
            for (int i = 0; i < cantCartas; i++) {
                for (Carta aux : baraja) {
                    System.out.println(aux);
                    RestoBaraja.add(aux);
                    baraja.remove(aux);
                    break;
                }
            }
        }
    }

    public void cartasMonton() {
        /**
         * El enunciado dice: "mostramos aquellas cartas que ya han salido, si no ha salido ninguna
         * indicárselo al usuario", por lo que asumo entonces que se trata de las cartas que se repartieron con anterioridad.
         */
        System.out.println("Cartas repartidas: ");
        for (Carta cartaM : RestoBaraja) {
            if (RestoBaraja.isEmpty()) {
                System.out.println("No hay mas cartas en el monton");
            } else {
                System.out.println(cartaM);
            }
        }
    }

    public void mostrarBaraja() {
        /**
         * "muestra todas las cartas hasta el final. Es decir, si se saca una
         * carta y luego se llama al método, este no mostrara esa primera carta."
         * O sea, ¿Las cartas que estan aun en el mazo? (Que todavia no se reparten).
         */
        System.out.println("> Cartas aun en el mazo:");
        for (Object auxM : baraja) {
            System.out.println(auxM);
        }
    }

}