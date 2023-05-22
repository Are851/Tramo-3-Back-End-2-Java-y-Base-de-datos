/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se 
gua rdará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los 
países guardados en el conjunto. (Recordemos hacer los servicios en la clase 
correspondiente) Después deberemos mostrar el conjunto ordenado alfabéticamente:
para esto recordar cómo se ordena un conjunto. 
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un 
Iterator, se buscará el país en el conjunto y si está en el conjunto se 
eliminará el país que ingresó el usuario y se mostrará el conjunto. Si el país 
no se encuentra en el conjunto se le informará al usuario. 
 */
package Servicios;

/**
 *
 * @author Rob
 */
import Entidad.Paises;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ServicioPaises {

    Scanner scanner = new Scanner(System.in);
    private Set<Paises> paises;
    Paises pais1 = new Paises();

    public ServicioPaises() {
        paises = new HashSet<>();
    }

    public void crearPaises() {
        String nombredepaises;

        boolean continuar = true;
        while (continuar) {
            ArrayList< String> paises2 = new ArrayList<>();
            System.out.println("Ingrese el nombre del pais");
            pais1.setNombrepaises(scanner.nextLine());
            paises2.add(pais1.getNombrepaises());
            System.out.println("¿Desea agregar otro país? (S/N)");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }

    }

    public void mostrarPaises() {
        for (Paises pais : paises) {
            System.out.println(pais);
        }

    }

    public void mostrarPaisesOrdenados() {
        Set<Paises> paisesOrdenados = new TreeSet<>(paises);
/// El metodo TreeSet ordena el conjunto
        for (Paises pais : paisesOrdenados) {
            System.out.println(pais);
        }
    }

    public void eliminarPais(String nombre) {
        Iterator<Paises> iterator = paises.iterator();
        while (iterator.hasNext()) {
            Paises pais = iterator.next();
            if (pais.getNombrepaises().equalsIgnoreCase(nombre)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("El país no se encuentra en el conjunto.");
    }
}
