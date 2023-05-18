package Main;

/*
1 - Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.

2 - Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.*/
//import Entidad.Perro;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ej2Perro3 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

//    ArrayList<Perro> perros = new ArrayList();
        ArrayList<String> perros = new ArrayList();
        Iterator<String> it = perros.iterator();

        String x;
        String rope;

        do {
//      Perro perro = new Perro();

            System.out.println("Raza de perro");
            rope = read.next();
//      perro.setRaza(rope);
//      perros.add(perro);

            perros.add(rope);

            do {
                System.out.println("Quiere seguir? S/N");
                x = read.next();
            } while (!x.equalsIgnoreCase("s") && !x.equalsIgnoreCase("n"));

        } while (!x.equalsIgnoreCase("n"));

        perros.forEach((g) -> {
            System.out.println(g);
        });

        System.out.println("Ingrese la raza a buscar: ");
        String raza = read.next();

//        int cantidad = Collections.frequency(perros,raza);
        boolean encontrado = false;

        while (it.hasNext()) {

            if (raza.equals(it.next())) {
                it.remove();
                encontrado = true;

            }
        }
        Collections.sort(perros);
//            perros.forEach((razas) -> {
//                System.out.println(razas);
//            });
        for (String razas : perros) {
            System.out.println(razas);
        }
        // Informar si el perro fue encontrado o no
        if (encontrado) {
            System.out.println("El perro ingresado  ha sido eliminado.");
        } else {
            System.out.println("El perro ingresadoEliminar no se encontró en la lista.");
        }

    }
}


