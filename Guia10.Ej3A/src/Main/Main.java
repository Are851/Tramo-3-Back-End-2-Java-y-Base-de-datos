/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Rob
 */

import Servicio.ServicioAlumnos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioAlumnos service = new ServicioAlumnos();

        while (true) {
            service.crearAlumnos();

            System.out.print("¿Desea agregar otro alumno? (s/n) ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.print("Ingrese el nombre del alumno para calcular su nota final: ");
        String nombreBuscado = scanner.nextLine();
        service.calcularNota(nombreBuscado);
        scanner.close();
    }
}
    

