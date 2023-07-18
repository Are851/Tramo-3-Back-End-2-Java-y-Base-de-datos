package servicios;
//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.

import entidades.Producto;
import java.util.Scanner;
import persistencia.ProductoDAO;

//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
public class ProductoServicio {

    private ProductoDAO pd = new ProductoDAO();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void mostrarProductosNombre() throws Exception {
        pd.mostrarProductosNombre();
    }

    public void mostrarProductosNombreyPrecio() throws Exception {
        pd.mostrarProductosNombreyPrecio();
    }

    public void mostrarProductosRangoPrecio() throws Exception {
        System.out.println("Ingrese el rango de precio que desea ver");
        System.out.println("Precio min");
        double min = leer.nextDouble();
        System.out.println("Precio max");
        double max = leer.nextDouble();
        pd.mostrarProductosRangoPrecio(min, max);
    }

    public void mostrarPortatiles() throws Exception {
        pd.mostrarPortatiles();
    }

    public void mostrarMasBarato() throws Exception {
        pd.mostrarMasBarato();
    }

    public void guardarProducto() throws Exception {
        Producto producto = new Producto();
        System.out.println("Ingrese el nombre del producto");
        String nombre = leer.next();
        producto.setNombre(nombre);
        System.out.println("Ingrese el precio del producto");
        double precio = leer.nextDouble();
        producto.setPrecio(precio);
        System.out.println("Ingrese el código del fabricante");
        int codigoFabricante = leer.nextInt();
        producto.setCodigo_fabricante(codigoFabricante);
        pd.ingresarProducto(producto);
    }

    public void editarProducto() {
        Producto producto = new Producto();
        
    }
}
