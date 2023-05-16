/*
Continuando el ejercicio anterior, después de mostrar los perros, al usuario 
se le pedirá un perro y se recorrerá la lista con un Iterator, se buscará el 
perro en la lista.  Si el perro está en la lista, se eliminará el perro que 
ingresó el usuario y se mostrará la lista ordenada. Si el perro no se encuentra
en la lista, se le informará al usuario y se mostrará la lista ordenada. 
 */
package guia10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Rob
 */
public class Ej2Perro2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de razas");
        int n = (scanner.nextInt());
        String raza;

        scanner.nextLine(); // Limpiar el buffer de entrada  scanner.nextLine(); // Limpiar el buffer de entrada

        ArrayList< String> perro = new ArrayList<>(n);
        ///opcion 1
        for (String perro1 : perro) {
            System.out.println("Ingrese el nombre de la raza");
            raza = scanner.nextLine();
            perro.add(raza);
        }
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

        // Pedir al usuario un perro a eliminar
        System.out.println("Ingrese raza de perro a eliminar de la lista");
        String perroeliminar = scanner.nextLine();

        Iterator<String> it = perro.iterator();
        boolean encontrado = false;

        // Buscar y eliminar el perro
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(perroeliminar)) {
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
        ///opcion 2 use functional operation
//        perro.forEach((razas) -> {
//            System.out.println(razas);
//        });
        // Informar si el perro fue encontrado o no
        if (encontrado) {
            System.out.println("El perro ingresado  ha sido eliminado.");
        } else {
            System.out.println("El perro ingresadoEliminar no se encontró en la lista.");
        }
    }
}
