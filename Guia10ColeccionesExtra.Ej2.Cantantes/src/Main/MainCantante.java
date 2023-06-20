/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Cantantes;
import Servicio.ServicioCantante;
import java.util.Scanner;

/**
 *
 * @author RobAre
 */
public class MainCantante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServicioCantante servicio = new ServicioCantante();
        Cantantes cantan = new Cantantes();

        servicio.crearLista();

        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un cantante");
            System.out.println("2. Mostrar todos los cantantes");
            System.out.println("3. Eliminar un cantante");
            System.out.println("4. Salir del programa");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el nombre del cantante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el disco con más ventas: ");
                    String discoConMasVentas = scanner.nextLine();
                    servicio.agregarCantante(nombre, discoConMasVentas);
                    System.out.println("Cantante agregado correctamente.");
                    break;
                case 2:
                    System.out.println("\nLista de cantantes:");
                    servicio.mostrarCantantes();
                    break;
                case 3:
                    servicio.eliminarCantante();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

    }
}
