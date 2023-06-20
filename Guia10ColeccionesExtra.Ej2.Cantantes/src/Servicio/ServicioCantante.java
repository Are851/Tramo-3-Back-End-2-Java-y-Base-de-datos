/* Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos
y tendrá como atributos el nombre y discoConMasVentas.
Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5
objetos de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres 
de cada cantante y su disco con más ventas por pantalla.
Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al 
usuario de agregar un cantante más, mostrar todos los cantantes, eliminar un 
cantante que el usuario elija o de salir del programa. Al final se deberá 
mostrar la lista con todos los cambios.
 */
package Servicio;
import Entidad.Cantantes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServicioCantante {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Cantantes> cantanteFamoso = new ArrayList<>();

    public void crearLista() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del cantante:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el disco más vendido del cantante:");
            String discoMasVendido = scanner.nextLine();
            Cantantes cantante = new Cantantes(nombre, discoMasVendido);
            cantanteFamoso.add(cantante);
        }
    }

    public void agregarCantante(String nombre, String discoConMasVentas) {
        Cantantes cantante = new Cantantes(nombre, discoConMasVentas);
        cantanteFamoso.add(cantante);
    }

    public void mostrarCantantes() {
        for (Cantantes cantante : cantanteFamoso) {
            System.out.println("Nombre: " + cantante.getNombrecantante());
            System.out.println("Disco con más ventas: " + cantante.getDiscoConMasVentas());
            System.out.println();
        }
    }

    public void eliminarCantante() {
        System.out.println("Ingrese el nombre del cantante a eliminar de la lista:");
        String nombre = scanner.nextLine();

        Iterator<Cantantes> iterator = cantanteFamoso.iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            Cantantes cantante = iterator.next();
            if (cantante.getNombrecantante().equals(nombre)) {
                iterator.remove();
                encontrado = true;
            }
        }

        if (encontrado) {
            System.out.println("Cantante eliminado correctamente.");
        } else {
            System.out.println("No se encontró un cantante con ese nombre en la lista.");
        }
    }
}