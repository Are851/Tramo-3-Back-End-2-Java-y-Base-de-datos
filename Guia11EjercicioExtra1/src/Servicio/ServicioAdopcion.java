
/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
package Servicio;

import Entidad.Perro;
import Entidad.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase que proporciona un servicio de adopción de perros a personas.
 * Permite crear personas, perros, asignar perros a las personas y mostrar la información de adopciones.
 */
public class ServicioAdopcion {

    Scanner leer = new Scanner(System.in);
    ArrayList<Persona> personas = new ArrayList<>();
    Map<String, Perro> perrosDisponibles = new HashMap<>();

    public void crearPersona() {
        // Pedir información de las personas
        System.out.print("Ingrese el número de personas: ");
        int numPersonas = leer.nextInt();

        leer.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < numPersonas; i++) {
            Persona persona = new Persona();

            System.out.print("Ingrese el nombre de la persona " + (i + 1) + ": ");
            persona.setNombre(leer.next());

            System.out.print("Ingrese edad: ");
            persona.setEdad(leer.nextInt());

            leer.nextLine(); // Consumir el salto de línea

            personas.add(persona);
        }
    }

    public void crearPerro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de perros: ");
        int cantidadPerros = scanner.nextInt();

        scanner.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < cantidadPerros; i++) {
            Perro perro = new Perro();
            System.out.print("Ingrese el nombre del perro #" + (i + 1) + ": ");
            perro.setNombre(scanner.nextLine());
            perrosDisponibles.put(perro.getNombre(), perro);
        }
    System.out.println("Perros disponibles:");
    for (Perro perro : perrosDisponibles.values()) {
        System.out.println(perro.getNombre());
    }
    }

    public void asignarPerros() {
        // Asignar perros a las personas
        for (Persona persona : personas) {
            System.out.print(persona.getNombre() + ", elija un perro por su nombre: ");
            String nombrePerro = leer.nextLine();

            if (perrosDisponibles.containsKey(nombrePerro)) {
                Perro perro = perrosDisponibles.get(nombrePerro);
                if (!perro.isAdoptado()) {
                    persona.setPerro(perro);
                    perro.setAdoptado(true);
                    System.out.println("¡Enhorabuena, has adoptado a " + perro.getNombre() + "!");
                } else {
                    System.out.println("El perro ya ha sido adoptado por otra persona.");
                }
            } else {
                System.out.println("No existe un perro con ese nombre.");
            }
        }
    }

    public void mostrarPerrosyPersonas() {
        // Mostrar información de las personas y sus perros
        System.out.println("Personas y sus perros:");
        for (Persona persona : personas) {
            System.out.println("Nombre de la persona: " + persona.getNombre());
            if (persona.getPerro() != null) {
                System.out.println("Nombre del perro adoptado: " + persona.getPerro().getNombre());
            } else {
                System.out.println("No ha adoptado ningún perro.");
            }
            System.out.println("-----------------------");
        }
    }
}
