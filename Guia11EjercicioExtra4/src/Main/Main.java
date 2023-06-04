/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Alumno;
import Servicio.Simulador;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Simulador simulador = new Simulador();

        List<Alumno> alumnos = simulador.generarListadoAlumnos(20);
        simulador.asignarNombresYDNI(alumnos);

        System.out.println("Listado de alumnos:");
        simulador.imprimirListadoAlumnos(alumnos);

        simulador.votacion(alumnos);

        System.out.println("Resultados de la votación:");
        simulador.mostrarResultados(alumnos);

        System.out.println("Recuento de votos:");
        simulador.contarVotos(alumnos);
    }
}


