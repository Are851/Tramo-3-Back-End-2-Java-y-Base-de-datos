package main;

//a) Lista el nombre de todos los productos que hay en la tabla producto.
import servicios.FabricanteServicio;
import servicios.ProductoServicio;

//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
public class Main {

    public static void main(String[] args) {
        ProductoServicio ps = new ProductoServicio();
        FabricanteServicio fs = new FabricanteServicio();
        try {
            fs.crearFabricante();
        } catch (Exception e) {

        }

    }
}
