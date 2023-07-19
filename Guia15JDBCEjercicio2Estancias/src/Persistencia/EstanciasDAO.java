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

    /*
    -- e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
    
    SELECT c.*, ca.descripcion FROM clientes c INNER JOIN estancias e ON c.id_cliente = e.id_cliente INNER JOIN casas ca ON e.id_casa = ca.id_casa;
     */
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import entidades.Estancias;

public class EstanciasDAO extends DAO {

    public ArrayList<Estancias> listarEstancias(String opc) throws Exception {
        String sql = "";

        if ("f".equals(opc)) {
            sql = "SELECT e.*, c.nombre AS nombre_cliente, c.pais AS pais_cliente,"
    + " c.ciudad AS ciudad_cliente "+ "FROM estancias e "
    + "INNER JOIN clientes c ON e.id_cliente = c.id_cliente";
        }

        if ("e".equals(opc)) {
            sql = "SELECT c.*, e.nombre_huesped, e.fecha_desde, e.fecha_hasta, casa.* "
                    + "FROM clientes c "
                    + "INNER JOIN estancias e ON c.id_cliente = e.id_cliente "
                    + "INNER JOIN casas casa ON e.id_casa = casa.id_casa";
        }

        ArrayList<Estancias> listaEstancias = new ArrayList<>();
        try {
            consultarBase(sql);
            while (resultado.next()) {
                Estancias estancia = new Estancias();
//                estancia.setId_estancia(resultado.getInt("id_estancia"));
                estancia.setId_cliente(resultado.getInt("id_cliente"));
                estancia.setId_casa(resultado.getInt("id_casa"));
                estancia.setNombre_huesped(resultado.getString("nombre_huesped"));
                estancia.setFecha_desde(resultado.getDate("fecha_desde").toLocalDate());
                estancia.setFecha_hasta(resultado.getDate("fecha_hasta").toLocalDate());
                listaEstancias.add(estancia);
            }
        } catch (Exception e) {
            System.out.println("ERROR en listarEstancias: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }

        return listaEstancias;
    }


//    public ArrayList<Estancias> listarEstancias(String opc) throws Exception {
//        if ("f".equals(opc)) {
//        String sql = ("SELECT e.*, c.nombre AS nombre_cliente, "
//+ "c.pais AS pais_cliente,"+ " c.ciudad AS ciudad_cliente\n" +
//"FROM estancias e\n" +"INNER JOIN clientes c ON e.id_cliente = c.id_cliente");
//        }
//        if ("e".equals(opc)) {
//        String sql = ("SELECT c.*, "+"e.nombre_huesped,"+ "e.fecha_desde,"+ e.fecha_hasta,"+ "casa.*"
//+"FROM clientes c"+"INNER JOIN estancias e ON c.id_cliente = e.id_cliente"+
//"INNER JOIN casas casa ON e.id_casa = casa.id_casa");   
//}
//        ArrayList<Estancias> listaEstancias = new ArrayList<>();
//        try {
//            consultarBase(sql);
//            while (resultado.next()) {
//                Estancias estancia = new Estancias();
//                estancia.setId_estancia(resultado.getInt("id_estancia"));
//                estancia.setId_cliente(resultado.getInt("id_cliente"));
//                estancia.setId_casa(resultado.getInt("id_casa"));
//                estancia.setNombre_huesped(resultado.getString("nombre_huesped"));
//                estancia.setFecha_desde(resultado.getDate("fecha_desde").toLocalDate());
//                estancia.setFecha_hasta(resultado.getDate("fecha_hasta").toLocalDate());
//                listaEstancias.add(estancia);
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR en listarEstancias: " + e.getMessage());
//            throw e;
//        } finally {
//            desconectarBase();
//        }
//
//        return listaEstancias;
//    }

    public void agregarEstancia(Estancias estancia) throws Exception {
        String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES ("
                + estancia.getId_cliente() + ", "
                + estancia.getId_casa() + ", '"
                + estancia.getNombre_huesped() + "', '"
                + Date.valueOf(estancia.getFecha_desde()) + "', '"
                + Date.valueOf(estancia.getFecha_hasta()) + "')";

        try {
            insertarModificarEliminar(sql);
            System.out.println("Estancia agregada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al agregar estancia: " + e.getMessage());
            throw e;
        }
    }

    public void eliminarEstancia(int idEstancia) throws Exception {
        String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia;

        try {
            insertarModificarEliminar(sql);
            System.out.println("Estancia eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al eliminar estancia: " + e.getMessage());
            throw e;
        }
           }
       }
  
