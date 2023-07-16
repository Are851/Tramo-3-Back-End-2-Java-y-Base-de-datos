/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

import java.sql.*;
import java.util.Scanner;

public class tienda {

    // Configuración de la conexión a la base de datos
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tienda";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Paso 1: Registrarse el JDBC driver
            Class.forName(JDBC_DRIVER);

            // Paso 2: Abrir la conexión
            System.out.println("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Paso 3: Crear el objeto Statement
            stmt = conn.createStatement();

            // Menú de opciones
            Scanner leer = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("Menú de consultas:");
                System.out.println("1. Listar nombre de todos los productos");
                System.out.println("2. Listar fabricantes");
                System.out.println("3. Salir");
                System.out.print("Ingrese el número de la opción deseada: ");
                //opcion = Integer.parseInt(System.console().readLine());
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        listarProductos(stmt);
                        break;
                    case 2:
                        listarFabricantes(stmt);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                        break;
                }
            } while (opcion != 3);

            // Paso 6: Cerrar el Statement y la conexión
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos en un bloque finally
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            } // No hacer nada

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        System.out.println("¡Adiós!");
    }

    public static void listarProductos(Statement stmt) throws SQLException {
        // Paso 4: Ejecutar la consulta
        String sql = "SELECT nombre, precio FROM producto ORDER BY nombre";
        ResultSet rs = stmt.executeQuery(sql);

        // Paso 5: Procesar el resultado
        while (rs.next()) {
            String nombreProducto = rs.getString("nombre");
            Double precioProducto = rs.getDouble("precio");
            System.out.println(nombreProducto + "     " + precioProducto);
        }

        rs.close();
    }

    public static void listarFabricantes(Statement stmt) throws SQLException {
        // Paso 4: Ejecutar la consulta
        String sql = "SELECT nombre, codigo FROM fabricante ORDER BY nombre";
        ResultSet rs = stmt.executeQuery(sql);

        // Paso 5: Procesar el resultado
        while (rs.next()) {
            String nombreFabricante = rs.getString("nombre");
            int codigoFabricante = rs.getInt("codigo");
            System.out.println(codigoFabricante + "   ----  " + nombreFabricante);
        }

        rs.close();
    }

}

