/*
6. Se necesita una aplicación para una tienda en la cual queremos almacenar los 
distintos productos que venderemos y el precio que tendrán. Además, se necesita 
que la aplicación cuente con las funciones básicas.  Estas las realizaremos en 
el servicio. Como, introducir un elemento, modificar su precio, eliminar un 
producto y mostrar los productos que tenemos con su precio (Utilizar Hashmap).
El HashMap tendrá de llave el nombre del producto y de valor el precio. 
Realizar un menú para lograr todas las acciones previamente mencionadas.  
 */
package Servicio;

/**
 *
 * @author RobAre
 */
import Entidad.Producto;
    import java.util.HashMap;
import java.util.Map;

public class ServicioProducto {
    private Map<String, Producto> productos;

    public ServicioProducto() {
        productos = new HashMap<>();
    }

    public void agregarProducto(String nombre, double precio) {
        Producto producto = new Producto(nombre, precio);
        productos.put(nombre, producto);
        System.out.println("Producto agregado exitosamente.");
    }

    public void modificarPrecio(String nombre, double nuevoPrecio) {
        if (productos.containsKey(nombre)) {
            Producto producto = productos.get(nombre);
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio modificado exitosamente.");
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }

    public void eliminarProducto(String nombre) {
        if (productos.containsKey(nombre)) {
            productos.remove(nombre);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }

    public void mostrarProductos() {
        System.out.println("=== Productos en inventario ===");
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
        System.out.println("===============================");
    }
}

