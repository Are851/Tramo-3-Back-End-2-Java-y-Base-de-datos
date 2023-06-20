/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10.extra.ej4;

/**
 *
 * @author RobAre
 */
/**
 * @param args the command line arguments
 */
import Entidad.Ciudad;
import Servicio.ServicioCodigosPostales;

import java.util.Scanner;

public class Guia10ExtraEj4 {

    public static void main(String[] args) {
        ServicioCodigosPostales servicio = new ServicioCodigosPostales();
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese 10 códigos postales y sus ciudades
        System.out.println("Ingrese 10 códigos postales y sus ciudades:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Código Postal: ");
            int codigoPostal = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.print("Ciudad: ");
            String ciudad = scanner.nextLine();

            servicio.agregarCiudad(codigoPostal, ciudad);
        }

        // Mostrar los datos introducidos
        System.out.println("Datos introducidos:");
        servicio.mostrarCodigosPostales();

        // Pedir un código postal y mostrar la ciudad asociada
        System.out.print("Ingrese un código postal: ");
        int codigoPostalBuscado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        Ciudad ciudadAsociada = servicio.buscarCiudad(codigoPostalBuscado);
        if (ciudadAsociada != null) {
            System.out.println("La ciudad asociada al código postal " + codigoPostalBuscado + " es: " + ciudadAsociada.getNombre());
        } else {
            System.out.println("No se encontró ninguna ciudad asociada al código postal " + codigoPostalBuscado);
        }

        // Agregar una ciudad con su código postal correspondiente al HashMap
        System.out.println("Agregar una ciudad:");

    }    }
