/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Baraja;
import Servicio.BarajaService;
import java.util.Scanner;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\\n");

        BarajaService sv = new BarajaService();
        Baraja baraja = sv.crearBaraja();
        String confirmacion;
        do {
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
            System.out.print("Para salir oprima (S): ");
            confirmacion = leer.next();

        } while (!confirmacion.equalsIgnoreCase("s"));
    }
}
