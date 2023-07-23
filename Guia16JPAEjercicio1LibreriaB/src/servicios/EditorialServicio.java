package servicios;

import entidades.Editorial;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class EditorialServicio {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EditorialDAO dao = new EditorialDAO();
    
    public Editorial crearEditorial() {
        Editorial editorial = new Editorial();
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();
        editorial.setNombre(nombre);
        editorial.setAlta(true);
        dao.persistirEntidad(editorial);
        return editorial;
    }
    
    public void darBaja() {
        System.out.println("Ingrese el id de la editorial que desea dar baja");
        Integer id = leer.nextInt();
        Editorial editorial = dao.buscarEditorial(id);
        editorial.setAlta(false);
        dao.actualizarEntidad(editorial);
    }
}
