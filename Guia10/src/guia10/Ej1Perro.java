/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de
tipo String. El programa pedirá una raza de perro en un bucle, 
el mismo se guardará en la lista y después se le preguntará al usuario si 
quiere guardar otro perro o si quiere salir. Si decide salir, se mostrará todos
los perros guardados en el ArrayList. 
 */
package guia10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ej1Perro {

    public static void main(String[] args) {

        ArrayList<String> perro = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean seguirAgregando = true;

        while(seguirAgregando) {
            System.out.print("Ingrese la raza del perro: ");

            String raza = scanner.nextLine();
            perro.add(raza);
            System.out.println("Quieres ingresar otra raza a la lista");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                seguirAgregando = false;
            }
            ///opcion 1
               System.out.println("Perros guardados:");
            for (String razas : perro) {
                System.out.println(razas);
            }
      ///opcion2
     ///use functional operations 
     ///Las operaciones funcionales son un conjunto de funciones que nos 
//     permiten procesar colecciones de datos de forma más concisa y expresiva 
//      en Java
            System.out.println("Perros guardados:");
            perro.forEach((razas) -> {
                System.out.println(razas);
            });
        }
               // Pedir al usuario un perro a eliminar
        System.out.println("Ingrese raza de perro a eliminar de la lista");
        String perroeliminar = scanner.nextLine();

        Iterator<String> it = perro.iterator();
        boolean encontrado = false;

        // Buscar y eliminar el perro
        while (it.hasNext()){
        String raza = it.next();
        if (raza.equalsIgnoreCase(perroeliminar)) {
            it.remove();
            encontrado = true;
        }
}
        
        // Mostrar la lista ordenada
        Collections.sort(perro);
        System.out.println("Razas de perros ordenado");
        for (String razas : perro) {
            System.out.println(razas);
        }
        // Informar si el perro fue encontrado o no
        if (encontrado) {
            System.out.println("El perro perroEliminar  ha sido eliminado.");
        } else {
            System.out.println("El perro perroEliminar no se encontró en la lista.");
        }
    }
}
