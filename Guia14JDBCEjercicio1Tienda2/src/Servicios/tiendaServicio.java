/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
import java.util.ArrayList;
import java.util.Scanner;
import Entidades.fabricante;
import Entidades.producto;
import Persistencia.tiendaDAO;

public class tiendaServicio {
    private final Scanner scanner;
    private final tiendaDAO dao;

    public tiendaServicio() {
        scanner = new Scanner(System.in);
        dao = new tiendaDAO();
    }

    public void Menu() throws Exception {
        int opcion;
        do {
            System.out.println("-------- Menú --------");
            System.out.println("1. Listar productos");
            System.out.println("2. Buscar productos por nombre");
            System.out.println("3. Buscar productos más baratos");
            System.out.println("4. Ingresar producto");
            System.out.println("5. Ingresar fabricante");
            System.out.println("6. Editar producto");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    buscarProductosPorNombre();
                    break;
                case 3:
                    buscarProductosMasBaratos();
                    break;
                case 4:
                    ingresarProducto();
                    break;
                case 5:
                    ingresarFabricante();
                    break;
                case 6:
                    editarProducto();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);
    }

    public void listarProductos() throws Exception {
        try {
            ArrayList<producto> productos = dao.listaProductos();
            if (productos.isEmpty()) {
                System.out.println("No hay productos registrados en la base de datos.");
            } else {
                System.out.println("---- Productos Registrados ----");
                for (producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de productos: " + e.getMessage());
        }
    }

    public void buscarProductosPorNombre() throws Exception {
        try {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            ArrayList<producto> productos = dao.buscarProductos(nombre);
            if (productos.isEmpty()) {
                System.out.println("No se encontraron productos con el nombre especificado.");
            } else {
                System.out.println("---- Productos Encontrados ----");
                for (producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
    }

    public void buscarProductosMasBaratos() throws Exception {
        try {
            ArrayList<producto> productos = dao.buscarProductosMasBaratos();
            if (productos.isEmpty()) {
                System.out.println("No se encontraron productos.");
            } else {
                System.out.println("---- Productos Más Baratos ----");
                for (producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar productos más baratos: " + e.getMessage());
        }
    }

    public void ingresarProducto() throws Exception {
        try {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.print("Ingrese el código del fabricante: ");
            int codigoFabricante = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            producto p = new producto();
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(codigoFabricante);

            dao.ingresarProducto(p);
            System.out.println("Producto ingresado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar el producto: " + e.getMessage());
        }
    }

    public void ingresarFabricante() throws Exception {
        try {
            System.out.print("Ingrese el nombre del fabricante: ");
            String nombre = scanner.nextLine();

            fabricante f = new fabricante();
            f.setNombre(nombre);

            dao.ingresarFabricante(f);
            System.out.println("Fabricante ingresado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar el fabricante: " + e.getMessage());
        }
    }

    public void editarProducto() throws Exception {
        try {
            System.out.print("Ingrese el código del producto a editar: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.print("Ingrese el nuevo código del fabricante: ");
            int codigoFabricante = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            producto p = new producto();
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(codigoFabricante);

            dao.editarProducto(p);
            System.out.println("Producto editado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al editar el producto: " + e.getMessage());
        }
    }
}
