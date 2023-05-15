/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Rob
 */
import Entidad.Pelicula;
import java.util.ArrayList;
import Servicio.PeliculaServicio;

public class Main {

    public static void main(String[] args) {
        PeliculaServicio ps = new PeliculaServicio();
        ArrayList<Pelicula> peliculas = ps.crearListaPeliculas();
        
        System.out.println("Mostrar peliculas");
        ps.mostrarPeliculas(peliculas);
        System.out.println("---------------------------");
        System.out.println("Mostrar duracion mayor a una hora");
        ps.mostrarPeliculasDuracion(peliculas);
        System.out.println("---------------------------");
        System.out.println("Mostrar de mayor a menor por duracion");
        ps.ordenarDuracionMayor(peliculas);
        System.out.println("---------------------------");
        System.out.println("Mostrar de menor a mayor por duracion");
        ps.mostrarDuracionMenor(peliculas);
        System.out.println("---------------------------");
        System.out.println("Mostrar por director");
        ps.mostrarDirector(peliculas);
        System.out.println("---------------------------");
        System.out.println("Mostrar titulo");
        ps.mostrarTitulo(peliculas);
    }
}


