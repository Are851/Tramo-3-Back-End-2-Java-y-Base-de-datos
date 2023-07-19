/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

import Persistencia.ClienteDAO;
import entidades.clientes;
import java.util.ArrayList;

public class ClientesServicio {

    private ClienteDAO clienteDAO;

    public ClientesServicio() {
        clienteDAO = new ClienteDAO();
    }

    public ArrayList<clientes> listarClientes() {
        try {
            return clienteDAO.listarClientes();
        } catch (Exception e) {
            System.out.println("ERROR al listar clientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void agregarCliente(clientes cliente) {
        try {
            clienteDAO.agregarCliente(cliente);
        } catch (Exception e) {
            System.out.println("ERROR al agregar cliente: " + e.getMessage());
        }
    }

    public void eliminarCliente(int idCliente) {
        try {
            clienteDAO.eliminarCliente(idCliente);
        } catch (Exception e) {
            System.out.println("ERROR al eliminar cliente: " + e.getMessage());
        }
    }
}
