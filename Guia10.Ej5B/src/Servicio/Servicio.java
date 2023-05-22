/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author RobAre
 */
public class Servicio {
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PaisServicio {

    public HashSet<String> cargarPaises(Scanner leer) {
        HashSet<String> paises = new HashSet();
        boolean bucle = true;
        String respuesta;
        do {
            System.out.println("Ingrese un país");
            paises.add(leer.next().toUpperCase());
            System.out.println("Desea ingresar otro país?");
            respuesta = leer.next();
            if (respuesta.equalsIgnoreCase("N")) {
                bucle = false;
            }
        } while (bucle);
        mostrarPaises(paises);
        return paises;
    }

    public void mostrarPaises(HashSet<String> paises) {
        for (String pais : paises) {
            System.out.println(pais);
        }
    }

    public void ordernarYmostrar(HashSet<String> paises) {
        TreeSet<String> paisesOrdenados = new TreeSet(paises);
//      ArrayList<String> paisesLista = new ArrayList(paises);
//      Collections.sort(paisesLista);
        for (String paisOrdenado : paisesOrdenados) {
            System.out.println(paisOrdenado);
        }
    }

    public void eliminarPais(HashSet<String> paises, Scanner leer) {
        Iterator<String> it = paises.iterator();
        System.out.println("Ingrese el país que desea eliminar");
        String paisRemover = leer.next().toUpperCase();
        boolean noEncontrado = true;
        while (it.hasNext()) {
            if (it.next().equals(paisRemover)) {
                it.remove();
                noEncontrado = false;
            }
        }
        if (noEncontrado) {
            System.out.println("NO se encontró el país que desea eliminar");
        }
    }
}   
}
