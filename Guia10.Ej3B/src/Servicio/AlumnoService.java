/*
3 - En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.

Después de ese bucle tendremos el siguiente método en el servicio de Alumno:

Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package Service;

import Entidad.Alumno;
import java.util.*;

public class AlumnoService {

    Scanner read = new Scanner(System.in);

    public Alumno crearAlumno() {
        Alumno alumno = new Alumno();

        System.out.println("Ingrese el nombre del alumno: ");
        alumno.setNombre(read.next());

        System.out.println("Ingrese sus tres notas");

        for (int i = 0; i < 3; i++) {
            alumno.addNota(read.nextInt());
        }

        return alumno;
    }

    public ArrayList curso() {
        ArrayList<Alumno> alumnos = new ArrayList();

        String x;

        do {
            alumnos.add(crearAlumno());

            do {
                System.out.println("Quiere ingresar otro alumno? S/N");
                x = read.next();
            } while (!x.equalsIgnoreCase("s") && !x.equalsIgnoreCase("n"));

        } while (!x.equalsIgnoreCase("n"));

        return alumnos;
    }

    public double notaFinal(ArrayList<Integer> notas) {
        double nota = 0;

        for (Integer x : notas) {
            nota += x;
        }

        return nota / 3;
    }
}
