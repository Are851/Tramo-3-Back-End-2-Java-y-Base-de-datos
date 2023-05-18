/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rob
 */
 import java.util.*;
/*
 * Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El 
 * programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y 
 * después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. +
 * Si decide salir, se mostrará todos los perros guardados en el ArrayList.
 */

public class Ej2Perro4 {
    /**
     * @param args
     */
    public static void main(String[] args)   {  
        ArrayList<String> perros = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        String mascota = "";
        String opcion = "";
        
        do {
            System.out.print("ingrese la raza del perro :");
            mascota = leer.next();
            perros.add(mascota);
            System.out.print("Desea agregar otra mascota (S/N)");
            opcion = leer.next().toUpperCase();
        } while (opcion.equalsIgnoreCase("S"));

        //System.out.print(perros);lambda
        perros.forEach((perro) -> {
            System.out.println(perro);
        });
//                for (String perro : perros) {
//            System.out.println(perro);
//        }

        /*
         * Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá un 
         * perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro 
         * está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista ordenada. 
         * Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará la lista ordenada.
         */
        String razaBuscada = "";
        System.out.print("Indica la raza del perro que deseas eliminar :");
        razaBuscada = leer.next();

        Iterator <String> it = perros.iterator();
        boolean encontre = false;
        while (it.hasNext()) {
            if (it.next().equals(razaBuscada)) {
                it.remove();
                encontre = true;
            }
        }
        Collections.sort(perros);

        if (!encontre)
            System.out.println("La raza " + razaBuscada + " no existe en la lista.");
        

    }   
}   

