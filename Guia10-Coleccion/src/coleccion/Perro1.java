/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleccion;

import java.util.ArrayList;
import java.util.Scanner;

public class Perro1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de razas");
        int n = (scanner.nextInt());
        String raza;

        scanner.nextLine(); // Limpiar el buffer de entrada  scanner.nextLine(); // Limpiar el buffer de entrada

        ArrayList< String> perro = new ArrayList<>(n);
        ///opcion 1
//        for (String perro1 : perro) {
//            System.out.println("Ingrese el nombre de la raza");
//            raza = scanner.nextLine();
//            perro.add(raza);
//        }
        ///opcion 2
//        for (int i = 0; i < perro.size(); i++) {
//            System.out.println("Ingrese el nombre de la raza");
//            raza = scanner.nextLine();
//            perro.add(raza);
//        }
//        /opcion 3
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el nombre de la raza");
            raza = scanner.nextLine();
            perro.add(raza);
        }
///opcion1
        perro.forEach((razas) -> {
            System.out.println(razas);
        });
///opcion2
//        for (String razas : perro) {
//            System.out.println(razas);
//        }
    }
}
