/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
//Realizar un menú en Java a través del cual se permita elegir qué consulta se desea realizar.
import java.util.Scanner;
import entidades.Producto;
import Servicios.ProductoServicio;

//Las consultas a realizar sobre la BD son las siguientes:
//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
public class Main {

    public static void main(String[] args) throws Exception {
        ProductoServicio productoServicio = new ProductoServicio();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("\n1. Listar todos los productos");
            System.out.println("2. Listar nombres de todos los productos");
            System.out.println("3. Listar nombres y precios de todos los productos");
            System.out.println("4. Listar productos con precios entre 120 y 202");
            System.out.println("5. Listar todos los portátiles");
            System.out.println("6. Listar el producto más barato");
            System.out.println("7. Agregar producto");
            System.out.println("8. Editar producto");
            System.out.println("9. Eliminar producto");
            System.out.println("10. Salir");

            System.out.println("Por favor, selecciona una opción: ");
            int option = leer.nextInt();

            switch (option) {
                case 1:
                    productoServicio.selectAll();
                    break;
                case 2:
                    productoServicio.selectPorParametro("nombre");
                    break;
                case 3:
                    productoServicio.selectPorParametro("nombre", "precio");
                    break;
                case 4:
                    productoServicio.listarPorPrecio(120, 202);
                    break;
                case 5:
                    productoServicio.listarPortatiles();
                    break;
                case 6:
                    productoServicio.obtenerProductoMasBarato();
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del pruducto");
                    String nombre = leer.next();
                    System.out.println("Ingrese el precio del producto");
                    Double precio = leer.nextDouble();
                    System.out.println("Ingrese el código del fabricante");
                    int fabricante = leer.nextInt();
                    Producto nuevoProducto = new Producto(nombre, precio, fabricante);
                    productoServicio.agregarProducto(nuevoProducto);
                    break;
                case 8:
                    System.out.println("Ingrese el código del producto que desea modificar");
                    int codigo = leer.nextInt();
                    System.out.println("Ingrese el nombre del pruducto");
                    String nombre2 = leer.next();
                    System.out.println("Ingrese el precio del producto");
                    Double precio2 = leer.nextDouble();
                    System.out.println("Ingrese el código del fabricante");
                    int fabricante2 = leer.nextInt();
                    Producto productoAEditar = new Producto(codigo, nombre2, precio2, fabricante2);
                    productoServicio.editarProducto(productoAEditar);
                    break;
                case 9:
                    System.out.println("Ingrese el código del producto que desea eliminar");
                    int codigoEliminar = leer.nextInt();
                    productoServicio.eliminarProducto(codigoEliminar);
                    break;
                case 10:
                    System.out.println("Adiós!");
                    return;
                default:
                    System.out.println("Opción no reconocida. Por favor, selecciona una opción del menú.");
            }
        }
    }
}