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


//    /*
//    -- e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
//
//    SELECT c.*, ca.descripcion FROM clientes c INNER JOIN estancias e ON c.id_cliente = e.id_cliente INNER JOIN casas ca ON e.id_casa = ca.id_casa;
//     */

import entidades.clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO extends DAO {

    public ArrayList<clientes> listarClientes() throws Exception {
        ArrayList<clientes> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        try {
            consultarBase(query);
            while (resultado.next()) {
                clientes cliente = new clientes();
                cliente.setId_cliente(resultado.getInt("id_cliente"));
                cliente.setNumero(resultado.getInt("numero"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setCalle(resultado.getString("calle"));
                cliente.setCodigo_postal(resultado.getString("codigo_postal"));
                cliente.setCiudad(resultado.getString("ciudad"));
                cliente.setPais(resultado.getString("pais"));
                cliente.setEmail(resultado.getString("email"));
                listaClientes.add(cliente);
            }
        } finally {
            desconectarBase();
        }
        return listaClientes;
    }

    public void agregarCliente(clientes cliente) throws Exception {
        String query = "INSERT INTO clientes (numero, nombre, calle, codigo_postal, ciudad, pais, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conectarBase();
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, cliente.getNumero());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getCalle());
            stmt.setString(4, cliente.getCodigo_postal());
            stmt.setString(5, cliente.getCiudad());
            stmt.setString(6, cliente.getPais());
            stmt.setString(7, cliente.getEmail());
            stmt.executeUpdate();
        } finally {
            desconectarBase();
        }
    }

    public void eliminarCliente(int idCliente) throws Exception {
        String query = "DELETE FROM clientes WHERE id_cliente = ?";
        try {
            conectarBase();
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        } finally {
            desconectarBase();
        }
    }
}
