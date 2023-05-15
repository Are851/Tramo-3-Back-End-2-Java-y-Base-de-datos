/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author Rob
 */
import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaServicio {

    public ArrayList<Pelicula> crearListaPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList();
        boolean confirmacion = true;
        do {
            Pelicula pelicula = new Pelicula();
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el nombre del director");
            pelicula.setDirector(leer.next());
            System.out.println("Ingrese el título de la película");
            pelicula.setTitulo(leer.next());
            System.out.println("Ingrese la duración de la película");
            pelicula.setDuracion(leer.nextInt());
            peliculas.add(pelicula);
            System.out.println("Desea ingresar otra pelicula? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                confirmacion = false;
            }
        } while (confirmacion);
        return peliculas;
    }

    public void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarPeliculasDuracion(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion() > 1) {
                System.out.println(pelicula);
            }
        }
    }

    public void ordenarDuracionMayor(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararDuracion);
        Collections.reverse(peliculas);
        mostrarPeliculas(peliculas);
    }

    public void mostrarDuracionMenor(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararDuracion);
        mostrarPeliculas(peliculas);
    }

    public void mostrarTitulo(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararTitulo);
        mostrarPeliculas(peliculas);
    }

    public void mostrarDirector(ArrayList<Pelicula> peliculas) {
        peliculas.sort(Pelicula.compararDirector);
        mostrarPeliculas(peliculas);
    }
}


