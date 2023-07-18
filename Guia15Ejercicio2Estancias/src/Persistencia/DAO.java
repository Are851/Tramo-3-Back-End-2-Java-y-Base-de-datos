/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
//  private final String DRIVER = "com.mysql.cj.jdbc.Driver"; Descomentar si 
//es la versión 8 de MySQL, se introdujo un nuevo controlador llamado 
//"Connector/J" que utiliza la cadena "com.mysql.cj.jdbc.Driver" como identificador.
    private final String DRIVER = "com.mysql.jdbc.Driver";
//En versiones anteriores de MySQL al 8, se utilizaba la cadena 
//"com.mysql.jdbc.Driver" como identificador del controlador JDBC

    protected void conectarBase() throws Exception {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR al conectarse a base de datos");
            throw ex;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            // conexion.rollback();
            /*  
            Descomentar la linea anterior si desean tener en cuenta el rollback.
            Correr el siguiente script en Workbench

            SET autocommit=1;
            COMMIT;

            **Sin rollback igual anda
             */
            System.out.println("ERROR al insertarModificarEliminar");
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println("ERROR consultar base de datos");
            throw ex;
        }
    }

}
