/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de
tipo String. El programa pedirá una raza de perro en un bucle, 
el mismo se guardará en la lista y después se le preguntará al usuario si 
quiere guardar otro perro o si quiere salir. Si decide salir, se mostrará todos
los perros guardados en el ArrayList. 
 */
package guia10;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej1Perro1 {

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
