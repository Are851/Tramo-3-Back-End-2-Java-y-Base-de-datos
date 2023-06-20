/*
 Implemente un programa para una Librería haciendo uso de un HashSet para evitar
datos repetidos. Para ello, se debe crear una clase llamada Libro que guarde la
información de cada uno de los libros de una Biblioteca. La clase Libro debe 
guardar el título del libro, autor, número de ejemplares y número de ejemplares
prestados. También se creará en el main un HashSet de tipo Libro que guardará 
todos los libros creados. 
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario 
todos sus datos y los seteandolos en el Libro. Despues, ese Libro se guarda en
el conjunto y se le pregunta al usuario si quiere crear otro Libro o no. 
La clase Librería contendrá además los siguientes métodos: 
• Constructor por defecto. 
• Constructor con parámetros. 
• Métodos Setters/getters 
• Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar
y se lo busca en el conjunto. Si está en el conjunto, se llama con ese objeto 
Libro al método. El método se incrementa de a uno, como un carrito de compras,
el atributo ejemplares prestados, del libro que ingresó el usuario. Esto 
sucederá cada vez que se realice un préstamo del libro. No se podrán prestar 
libros de los que no queden ejemplares disponibles para prestar. Devuelve true
si se ha podido realizar la operación y false en caso contrario. 
• Método devolucion(): El usuario ingresa el titulo del libro que quiere 
devolver y se lo busca en el conjunto. Si está en el conjunto, se llama con 
ese objeto al método. El método decrementa de a uno, como un carrito de compras,
el atributo ejemplares prestados, del libro seleccionado por el usuario. 
Esto sucederá cada vez que se produzca la devolución de un libro. No se podrán
devolver libros donde que no tengan ejemplares prestados. Devuelve true si se
ha podido realizar la operación y false en caso contrario.
• Método toString para mostrar los datos de los libros. 

 */
package guia10;

import Entidad.Libro;
import Servicio.ServicioLibreria;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author RobAre
 */
public class Guia10ExtraEj3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Libro> libros = new HashSet<>();
        ServicioLibreria servicio = new ServicioLibreria(libros); 

        Scanner scanner = new Scanner(System.in);
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el título del libro:");
            String titulo = scanner.nextLine();

            System.out.println("Ingrese el autor del libro:");
            String autor = scanner.nextLine();

            System.out.println("Ingrese el número de ejemplares del libro:");
            int numEjemplares = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            Libro libro = new Libro( titulo,  autor,  numEjemplares);
            libros.add(libro);

            System.out.println("¿Desea crear otro libro? (S/N)");
            String respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }
        boolean realizarOperacion = true;
        while (realizarOperacion) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Prestamo de libro");
            System.out.println("2. Devolución de libro");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del entero

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro a prestar:");
                    String titulo = scanner.nextLine();
                    boolean prestamoExitoso = servicio.prestamo(titulo);
                    if (prestamoExitoso) {
                        System.out.println("El libro ha sido prestado exitosamente.");
                    } else {
                        System.out.println("No se pudo realizar el préstamo. No hay ejemplares disponibles.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el título del libro a devolver:");
                    String tituloDevolucion = scanner.nextLine();
                    boolean devolucionExitosa = servicio.devolucion(tituloDevolucion);
                    if (devolucionExitosa) {
                        System.out.println("El libro ha sido devuelto exitosamente.");
                    } else {
                        System.out.println("No se pudo realizar la devolución. No hay ejemplares prestados.");
                    }
                    break;
                case 3:
                    servicio.mostrarLibros();
                    break;
                case 4:
                    realizarOperacion = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}


    
