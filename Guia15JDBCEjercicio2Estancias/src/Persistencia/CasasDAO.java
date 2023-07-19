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
    -- b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 
    -- 2020 y el 31 de agosto de 2020 en Reino Unido.

    select * from casas where pais like 'Reino Unido' and fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31';
    
    -- d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada 
    -- y un número de días específico.

    -- deberás proporcionar los valores '?' correspondientes a los parámetros en el mismo orden en el que aparecen en la consulta

    select * from casas where fecha_desde >= '?' AND fecha_hasta <= '?' AND tiempo_minimo_dias >= '?' AND tiempo_maximo_dias <= '?';
    
    
    -- g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el 
    -- precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.

    UPDATE casas SET precio_habitacion = precio_habitacion * 1.05 WHERE pais = 'Reino Unido' LIMIT 100;
    
    -- h) Obtener el número de casas que existen para cada uno de los países diferentes.

    SELECT pais, COUNT(*) AS numero_casas FROM casas GROUP BY pais;
    
    -- i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) 
    -- que están ‘limpias’.

    SELECT c.*, co.comentario FROM casas c INNER JOIN comentarios co ON c.id_casa = co.id_casa WHERE c.pais = 'Reino Unido' AND co.comentario LIKE '%limpia%' ;
     */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Casas;
import java.util.Scanner;

public class CasasDAO extends DAO {
    public void insertarCasa(Casas casa) throws Exception {
        
        String sql = "INSERT INTO casas (calle, codigo_postal, ciudad, pais, numero, tiempo_minimo, fecha_desde, fecha_hasta, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conectarBase();
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, casa.getCalle());
            statement.setString(2, casa.getCodigo_postal());
            statement.setString(3, casa.getCiudad());
            statement.setString(4, casa.getPais());
            statement.setInt(5, casa.getNumero());
            statement.setInt(6, casa.getTiempo_minimo());
            statement.setDate(7, casa.getFecha_desde());
            statement.setDate(8, casa.getFecha_hasta());
            statement.setInt(9, casa.getTiempo_maximo());
            statement.setDouble(10, casa.getPrecio_habitacion());
            statement.setString(11, casa.getTipo_vivienda());

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR al insertar la casa: " + ex.getMessage());
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    public void actualizarCasa(Casas casa) throws Exception {
        String sql = "UPDATE casas SET calle = ?, codigo_postal = ?, ciudad = ?, pais = ?, numero = ?, tiempo_minimo = ?, fecha_desde = ?, fecha_hasta = ?, tiempo_maximo = ?, precio_habitacion = ?, tipo_vivienda = ? WHERE id_casa = ?";
        try {
            conectarBase();
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, casa.getCalle());
            statement.setString(2, casa.getCodigo_postal());
            statement.setString(3, casa.getCiudad());
            statement.setString(4, casa.getPais());
            statement.setInt(5, casa.getNumero());
            statement.setInt(6, casa.getTiempo_minimo());
            statement.setDate(7, casa.getFecha_desde());
            statement.setDate(8, casa.getFecha_hasta());
            statement.setInt(9, casa.getTiempo_maximo());
            statement.setDouble(10, casa.getPrecio_habitacion());
            statement.setString(11, casa.getTipo_vivienda());
            statement.setInt(12, casa.getId_casa());

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR al actualizar la casa: " + ex.getMessage());
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarCasa(int idCasa) throws Exception {
        String sql = "DELETE FROM casas WHERE id_casa = ?";
        try {
            conectarBase();
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idCasa);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR al eliminar la casa: " + ex.getMessage());
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    public Casas obtenerCasaPorId(int idCasa) throws Exception {
        Casas casa = null;
        String sql = "SELECT * FROM casas WHERE id_casa = ?";
        try {
            conectarBase();
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idCasa);

            resultado = statement.executeQuery();
            if (resultado.next()) {
                casa = new Casas();
                casa.setId_casa(resultado.getInt("id_casa"));
                casa.setCalle(resultado.getString("calle"));
                casa.setCodigo_postal(resultado.getString("codigo_postal"));
                casa.setCiudad(resultado.getString("ciudad"));
                casa.setPais(resultado.getString("pais"));
                casa.setNumero(resultado.getInt("numero"));
                casa.setTiempo_minimo(resultado.getInt("tiempo_minimo"));
                casa.setFecha_desde(resultado.getDate("fecha_desde"));
                casa.setFecha_hasta(resultado.getDate("fecha_hasta"));
                casa.setTiempo_maximo(resultado.getInt("tiempo_maximo"));
                casa.setPrecio_habitacion(resultado.getDouble("precio_habitacion"));
                casa.setTipo_vivienda(resultado.getString("tipo_vivienda"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR al obtener la casa por ID: " + ex.getMessage());
            throw ex;
        } finally {
            desconectarBase();
        }
        return casa;
    }

    public List<Casas> obtenerTodasLasCasas() throws Exception {
        List<Casas> casas = new ArrayList<>();
        String sql = "SELECT * FROM casas";
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                Casas casa = new Casas();
                casa.setId_casa(resultado.getInt("id_casa"));
                casa.setCalle(resultado.getString("calle"));
                casa.setCodigo_postal(resultado.getString("codigo_postal"));
                casa.setCiudad(resultado.getString("ciudad"));
                casa.setPais(resultado.getString("pais"));
                casa.setNumero(resultado.getInt("numero"));
                casa.setTiempo_minimo(resultado.getInt("tiempo_minimo"));
                casa.setFecha_desde(resultado.getDate("fecha_desde"));
                casa.setFecha_hasta(resultado.getDate("fecha_hasta"));
                casa.setTiempo_maximo(resultado.getInt("tiempo_maximo"));
                casa.setPrecio_habitacion(resultado.getDouble("precio_habitacion"));
                casa.setTipo_vivienda(resultado.getString("tipo_vivienda"));

                casas.add(casa);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR al obtener todas las casas: " + ex.getMessage());
            throw ex;
        } finally {
            desconectarBase();
        }
        return casas;
    }
    public ArrayList<Casas> listarCasas(String opc) throws Exception {
        ArrayList<Casas> listarCasas = new ArrayList();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        String sql = "";
        if ("b".equals(opc)) {
            sql = "SELECT * FROM casas WHERE pais LIKE 'Reino Unido' AND fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31' ";
        } else if ("g".equals(opc)) {
            sql = "UPDATE casas SET precio_habitacion = precio_habitacion * 1.05 WHERE pais = 'Reino Unido' LIMIT 100 ";
        } else if ("h".equals(opc)) {
            sql = "SELECT pais, COUNT(*) AS numero_casas FROM casas GROUP BY pais ";
        } else if ("i".equals(opc)) {
            sql = "SELECT c.*, co.comentario FROM casas c INNER JOIN comentarios co "
                    + "ON c.id_casa = co.id_casa WHERE c.pais = 'Reino Unido' AND co.comentario LIKE '%limpia%' ";
 } else if ("d".equals(opc)) {
            System.out.println(" Ingrese desde que fecha (a partir de 2020-08-01) : ");
            String fd = leer.nextLine();
            System.out.println(" Ingrese hasta que fecha (hasta 2020-08-31) : ");
            String fh = leer.nextLine();
            System.out.println(" Ingrese Tiempo minimo de dias  desde 1: ");
            String dmin = leer.nextLine();
            System.out.println(" Ingrese Tiempo maximo de dias hasta 30: ");
            String dmax = leer.nextLine(); 
            sql = " select * from casas where fecha_desde >= '"+ fd +"' AND fecha_hasta"
+ " <= '"+ fh +"' AND tiempo_minimo >= '"+ dmin +"' AND tiempo_maximo <= '"+ dmax +"' ";
        }
        try {
            if ("g".equals(opc)) {
                insertarModificarEliminar(sql);
                System.out.println(" BASE DE DATOS ACTUALIZADA ");
            } else {
            consultarBase(sql);
            while (resultado.next()) {
               Casas c = new Casas();
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_minimo(resultado.getInt(9));
                c.setTiempo_maximo(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getInt(11));
                c.setTipo_vivienda(resultado.getString(12));
                listarCasas.add(c);
            }
            }
        } catch (Exception exc) {
            System.out.println("ERROR en listaCasas ");
            System.out.println(exc);
        } finally {
            desconectarBase();
        }
        return listarCasas;
    }

}
