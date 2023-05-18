package Main;

import Entidad.Alumno;
import Service.AlumnoService;
import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        AlumnoService service = new AlumnoService();
        ArrayList<Alumno> alumnos = service.curso();;

        System.out.println("Ingresa el nombre del alumno: ");
        String alumne = read.next();

        alumnos.forEach((d) -> {
            if (alumne.equalsIgnoreCase(d.getNombre())) {
                System.out.println("El promedio final de " + alumne + " es: " + service.notaFinal(d.getNotas()));
            }
        });
    }

}
