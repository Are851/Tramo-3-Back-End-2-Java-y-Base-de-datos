package servicios;
//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.

import entidades.Fabricante;
import java.util.Scanner;
import persistencia.FabricanteDAO;

//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
public class FabricanteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    FabricanteDAO fd = new FabricanteDAO();

    public void crearFabricante() throws Exception {
        Fabricante fabricante = new Fabricante();
        System.out.println("Ingrese el nombre del fabricante");
        String nombre = leer.next();
        fabricante.setNombre(nombre);
        fd.guardarFabricante(fabricante);
    }
}
