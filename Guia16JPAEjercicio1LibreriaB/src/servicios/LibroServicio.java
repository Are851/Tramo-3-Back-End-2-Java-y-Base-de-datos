package servicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.Scanner;
import persistencia.LibroDAO;

public class LibroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibroDAO dao = new LibroDAO();

    public void crearLibro() {
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        Libro libro = new Libro();
        System.out.println("Ingrese el ISBN del libro");
        long ISBN = leer.nextLong();
        libro.setISBN(ISBN);
        System.out.println("Ingrese el titulo del libro");
        String titulo = leer.next();
        libro.setTitulo(titulo);
        System.out.println("Ingrese el año de edición");
        int anio = leer.nextInt();
        libro.setAnio(anio);
        System.out.println("Ingrese la cantidad de ejemplares");
        int cantidadEjemplares = leer.nextInt();
        libro.setEjemplares(cantidadEjemplares);
        libro.setEjemplaresRestantes(cantidadEjemplares);
        libro.setEjemplaresPrestados(0);
        libro.setAlta(true);
        Autor autor = as.crearAutor();
        libro.setAutor(autor);
        Editorial editorial = es.crearEditorial();
        libro.setEditorial(editorial);
        dao.persistirEntidad(libro);
    }

    public void darBaja() {
        System.out.println("Ingrese el ISBN del libro que desea dar baja");
        long ISBN = leer.nextInt();
        Libro libro = dao.buscarLibroId(ISBN);
        libro.setAlta(false);
        dao.actualizarEntidad(libro);
    }
}
