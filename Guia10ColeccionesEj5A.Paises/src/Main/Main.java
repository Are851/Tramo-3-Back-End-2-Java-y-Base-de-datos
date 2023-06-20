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
import Servicios.ServicioPaises;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServicioPaises servicioPaises = new ServicioPaises();
        Scanner scanner = new Scanner(System.in);

        servicioPaises.crearPaises();

        System.out.println("Países guardados:");
        servicioPaises.mostrarPaises();

        System.out.println("Países ordenados alfabéticamente:");
        servicioPaises.mostrarPaisesOrdenados();

        System.out.println("Ingrese el nombre de un país a eliminar:");
        String paisEliminar = scanner.nextLine();
        servicioPaises.eliminarPais(paisEliminar);

        System.out.println("Conjunto de países después de eliminar:");
        servicioPaises.mostrarPaises();
    }
}
