package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Prestamo;
import static libreria.entidades.Prestamo_.cliente;
import persistencia.ClienteDao;
import persistencia.PrestamoDao;

public class ClienteServicio {

     ClienteDao cd = new ClienteDao();

    public Cliente crearCliente() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Cliente cliente = new Cliente();
        do {
            try {
                System.out.println("Ingrese el documento del cliente");
                int documento = leer.nextInt();
                Cliente cliente2 = cd.buscarCliente(documento);
                if(cliente2 != null){
                    System.out.println("Cliente ya registrado.");
                    return cliente2;
                }
                cliente.setId(documento);
                cliente.setDocumento(documento);
                break;
            } catch (Exception e) {
                System.out.println("Documento mal ingresado");
                leer.next();
            }
        } while (true);
        System.out.println("Ingrese el nombre del cliente");
        cliente.setNombre(leer.next());
        System.out.println("Ingrese el apellido del cliente");
        cliente.setApellido(leer.next());
        System.out.println("Ingrese el nro de teléfono del cliente");
        cliente.setTelefono(leer.next());
        cd.persistirCliente(cliente);
        return cliente;
    }

        public List<Cliente> consultarCliente(){
        return cd.consultaCliente();
    }   
        
private ClienteDao clienteDao;

    public ClienteServicio() {
        clienteDao = new ClienteDao();
    }

   public Cliente buscarClientePorNombre(String nombreCliente) {
        List<Cliente> clientes = clienteDao.consultaCliente(); // Obtener la lista de clientes desde la base de datos

        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente; // Retorna el objeto Cliente si se encuentra el nombre
            }
        }

        return null; // Si no se encuentra el cliente, retorna null
    }
}

