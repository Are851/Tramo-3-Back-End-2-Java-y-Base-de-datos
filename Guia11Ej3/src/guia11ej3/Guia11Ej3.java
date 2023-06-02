/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia11ej3;

import Entidad.Baraja;
import Servicio.BarajaService;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Guia11Ej3 {
    public static void main(String[] args) {
        BarajaService sv = new BarajaService();
        Baraja baraja = sv.crearBaraja();
        System.out.println(baraja.toString());
        sv.barajar(baraja);
        System.out.println(baraja);
        System.out.println("Cartas Disponibles: " + sv.cartasDisponibles(baraja));
        for (int i = 0; i < 5; i++) {
            System.out.println(sv.siguienteCarta(baraja)); 
        }
        System.out.println("Cartas Disponibles: " + sv.cartasDisponibles(baraja));
        sv.darCartas(baraja);
        System.out.println("Cartas del montón");
        sv.cartasMonton(baraja);
        System.out.println("Cantidad del montón: " + baraja.getMonton().size());
        System.out.println("Cartas Disponibles: " + sv.cartasDisponibles(baraja));
        System.out.println("Cartas que le quedan a la baraja");
        sv.mostrarBaraja(baraja);
    }
    }
