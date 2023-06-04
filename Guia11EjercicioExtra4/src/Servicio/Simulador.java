

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
package Servicio;

import Entidad.Alumno;
import Entidad.Voto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Simulador {
    private Random random;

    public Simulador() {
        random = new Random();
    }

    public List<Alumno> generarListadoAlumnos(int cantidad) {
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            alumnos.add(new Alumno("", 0));
        }
        return alumnos;
    }

    public void asignarNombresYDNI(List<Alumno> alumnos) {
        List<String> nombres = Arrays.asList("Juan", "María", "Carlos", "Laura", "Pedro", "Ana", "Luis", "Marta");
        List<String> apellidos = Arrays.asList("González", "Rodríguez", "López", "Fernández", "Pérez", "Gómez", "Torres", "Ramírez");

        Set<String> nombresUtilizados = new HashSet<>();
        Set<Integer> dnisUtilizados = new HashSet<>();

        for (Alumno alumno : alumnos) {
            String nombreCompleto;
            int dni;

            do {
                nombreCompleto = generarNombreCompleto(nombres, apellidos);
            } while (nombresUtilizados.contains(nombreCompleto));

            do {
                dni = generarDNI();
            } while (dnisUtilizados.contains(dni));

            alumno.setNombreCompleto(nombreCompleto);
            alumno.setDNI(dni);
            nombresUtilizados.add(nombreCompleto);
            dnisUtilizados.add(dni);
        }
    }

    private String generarNombreCompleto(List<String> nombres, List<String> apellidos) {
        String nombre = nombres.get(random.nextInt(nombres.size()));
        String apellido = apellidos.get(random.nextInt(apellidos.size()));
        return nombre + " " + apellido;
    }

    private int generarDNI() {
        int numero = random.nextInt(90000000) + 10000000;
        return numero;
    }

    public void imprimirListadoAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombreCompleto());
            System.out.println("DNI: " + alumno.getDNI());
            System.out.println("Cantidad de votos: " + alumno.getCantidadVotos());
            System.out.println("-----------------------");
        }
    }

    public void votacion(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            Voto voto = new Voto(alumno);
            Set<Alumno> votados = new HashSet<>();

            while (votados.size() < 3) {
                Alumno alumnoVotado = obtenerAlumnoAleatorio(alumnos);
                if (alumno != alumnoVotado && !votados.contains(alumnoVotado)) {
                    voto.agregarVoto(alumnoVotado);
                    votados.add(alumnoVotado);
                    alumnoVotado.incrementarVoto();
                }
            }
        }
    }

    private Alumno obtenerAlumnoAleatorio(List<Alumno> alumnos) {
        int indiceAleatorio = random.nextInt(alumnos.size());
        return alumnos.get(indiceAleatorio);
    }

    public void mostrarResultados(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto());
            System.out.println("Cantidad de votos: " + alumno.getCantidadVotos());
            System.out.println("Votos recibidos:");
            for (Alumno votado : alumno.getVotos()) {
                System.out.println("- " + votado.getNombreCompleto());
            }
            System.out.println("-----------------------");
        }
    }

    public void contarVotos(List<Alumno> alumnos) {
        if (alumnos.size() >= 10) {
            Collections.sort(alumnos, Comparator.comparingInt(Alumno::getCantidadVotos).reversed());
            System.out.println("Facilitadores:");
            for (int i = 0; i < 5; i++) {
                Alumno facilitador = alumnos.get(i);
                System.out.println((i + 1) + ". " + facilitador.getNombreCompleto() + " - Votos: " + facilitador.getCantidadVotos());
            }
            System.out.println("-----------------------");
            System.out.println("Facilitadores suplentes:");
            for (int i = 5; i < 10; i++) {
                Alumno facilitadorSuplente = alumnos.get(i);
                System.out.println((i - 4) + ". " + facilitadorSuplente.getNombreCompleto() + " - Votos: " + facilitadorSuplente.getCantidadVotos());
            }
        } else {
            System.out.println("No hay suficientes alumnos para realizar el recuento de votos.");
        }
    }
}
