/*
6. Se necesita una aplicación para una tienda en la cual queremos almacenar los 
distintos productos que venderemos y el precio que tendrán. Además, se necesita 
que la aplicación cuente con las funciones básicas.  Estas las realizaremos en 
el servicio. Como, introducir un elemento, modificar su precio, eliminar un 
producto y mostrar los productos que tenemos con su precio (Utilizar Hashmap).
El HashMap tendrá de llave el nombre del producto y de valor el precio. 
Realizar un menú para lograr todas las acciones previamente mencionadas.  
 */
package Main;

/**
 *
 * @author RobAre
 */
import java.util.*;
import Entidad.ServicioProducto;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioProducto servicios = new ServicioProducto();

        int opcion;
        do {
            System.out.println("==== MENÚ ====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar precio de un producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    servicios.agregarProducto(nombre, precio);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a modificar: ");
                    nombre = scanner.next();
                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    servicios.modificarPrecio(nombre, nuevoPrecio);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    nombre = scanner.next();
                    servicios.eliminarProducto(nombre);
                    break;
                case 4:
                    servicios.mostrarProductos();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println(
            

}
