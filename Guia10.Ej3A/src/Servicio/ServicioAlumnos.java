/*
Crear una clase llamada Alumno que mantenga información sobre las notas de
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una 
lista de tipo Integer con sus 3 notas.  En el servicio de Alumno deberemos 
tener un bucle que crea un objeto Alumno. Se pide toda la información al 
usuario y ese Alumno se guarda en una lista de tipo Alumno y se le pregunta
al usuario si quiere crear otro Alumno o no. Después de ese bucle tendremos 
el siguiente método en el servicio de Alumno:  Método notaFinal(): El usuario 
ingresa el nombre del alumno que quiere calcular su nota final y se lo busca en
la lista de Alumnos.  Si está en la lista, se llama al método. Dentro del 
método se usará la lista notas para calcular el promedio final de alumno. 
Siendo este promedio final, devuelto por el método y mostrado en el main. 
 */
package Servicio;

import java.util.Scanner;
import Entidad.Alumnos;
import java.util.ArrayList;

/**
 *
 * @author Rob
 */
public class ServicioAlumnos {

    Scanner scan = new Scanner(System.in);
    Alumnos alumnos1 =new Alumnos();

    private ArrayList<Alumnos> alumno;

    public ServicioAlumnos() {
    }

    public ServicioAlumnos(ArrayList<Alumnos> alumno) {
        this.alumno = alumno;
    }

    public void crearAlumnos() {
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Ingrese nombre del alumno");
        String nombre = scan1.nextLine();
        
        ArrayList<Integer> notas = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese nota");
            int nota = scan1.nextInt();
            notas.add(nota);
        }
        scan1.nextLine(); // Consumir la línea vacía después del input de la última nota
        
        Alumnos alumno1 = new Alumnos(notas, nombre);
        alumno.add(alumno1);
        scan1.close();

    }

    public double notaFinal(ArrayList<Integer> notas) {
        double suma = 0;
        for (Integer nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public void calcularNota(String nombreBuscado) {
        boolean encontrado = false;
        for (Alumnos listadealumnos : alumno) {
            if (alumnos1.getNombre().equalsIgnoreCase(nombreBuscado)) {
                double notaFinal = notaFinal(listadealumnos.getNotas());

                System.out.println("La nota final de" + nombreBuscado + "es" + notaFinal);
                encontrado = true;
                break;
            }

        }
        if (!encontrado) {
            System.out.println("El alumno " + nombreBuscado + " no está en la lista.");
        }
    }
}
