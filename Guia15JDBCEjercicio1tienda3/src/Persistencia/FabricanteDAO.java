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
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entidades.Fabricante;

public class FabricanteDAO extends DAO {

    public ArrayList<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);
            ArrayList<Fabricante> fabricantes = new ArrayList<>();
            while (resultado.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
                fabricantes.add(fabricante);
            }
            return fabricantes;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void agregarFabricante(Fabricante fabricante) throws Exception {
        try {
            String sql = "INSERT INTO fabricante (codigo, nombre) VALUES (" 
                + fabricante.getCodigo() + ", '" + fabricante.getNombre() + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void editarFabricante(Fabricante fabricante) throws Exception {
        try {
            String sql = "UPDATE fabricante SET nombre = '" + fabricante.getNombre() 
                + "' WHERE codigo = " + fabricante.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricante(int codigoFabricante) throws Exception {
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " + codigoFabricante;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
