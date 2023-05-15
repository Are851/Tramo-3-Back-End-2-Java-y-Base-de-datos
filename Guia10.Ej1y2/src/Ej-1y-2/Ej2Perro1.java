/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Ej2Perro1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> razas = new ArrayList();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean confirmacion = true;
        do {
            System.out.println("Ingrese la raza del perro");
            razas.add(leer.next().toUpperCase());
            System.out.println("Desea agregar otro perro? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                confirmacion = false;
            }
        } while (confirmacion);

        for (String raza : razas) {
            System.out.println(raza);
        }
        System.out.println("Ingrese el perro que desea ELIMINAR");
        String perroELIMINAR = leer.next();
        boolean noEncotrado = true;
        Iterator it = razas.iterator();
        while (it.hasNext()) {
            if (it.next().equals(perroELIMINAR)) {
                it.remove();
                noEncotrado = false;
            }
        }

        if (noEncotrado) {
            System.out.println("NO se encontró el perro a eliminar");
        }
        Collections.sort(razas);
        for (String raza : razas) {
            System.out.println(raza);
        }
    }
}
