/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de
tipo String. El programa pedirá una raza de perro en un bucle, 
el mismo se guardará en la lista y después se le preguntará al usuario si 
quiere guardar otro perro o si quiere salir. Si decide salir, se mostrará todos
los perros guardados en el ArrayList. 
 */
package coleccion;

import java.util.ArrayList;
import java.util.Scanner;

public class Perro {

    public static void main(String[] args) {

        ArrayList<String> perros = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean seguirAgregando = true;

        while(seguirAgregando) {
            System.out.print("Ingrese la raza del perro: ");

            String raza = scanner.nextLine();
            perros.add(raza);
            System.out.println("Quieres ingresar otra raza a la lista");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                seguirAgregando = false;
            }
            ///opcion 1
               System.out.println("Perros guardados:");
            for (String razas : perros) {
                System.out.println(razas);
            }
      ///opcion2
     ///use functional operations 
     ///Las operaciones funcionales son un conjunto de funciones que nos 
//     permiten procesar colecciones de datos de forma más concisa y expresiva 
//      en Java
            System.out.println("Perros guardados:");
            perros.forEach((razas) -> {
                System.out.println(razas);
            });
        }
       
    }
}
