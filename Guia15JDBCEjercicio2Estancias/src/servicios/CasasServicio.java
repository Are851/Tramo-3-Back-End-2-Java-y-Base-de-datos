package servicios;

import Persistencia.CasasDAO;
import entidades.Casas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CasasServicio {
    private Connection conexion;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    public CasasServicio() {
        conectarBase();
    }

    private void conectarBase() {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("ERROR al conectarse a la base de datos: " + e.getMessage());
        }
    }

    private void desconectarBase() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR al desconectar la base de datos: " + e.getMessage());
        }
    }

    public void listarCasas(String opc) {
        try {
            CasasDAO casasDAO = new CasasDAO();
            List<Casas> casas = casasDAO.listarCasas(opc);

            for (Casas aux : casas) {
                System.out.println(aux.toString());
            }
        } catch (Exception e) {
            System.out.println("ERROR al listar las casas: " + e.getMessage());
        }
    }
}

//    public List<Casas> listarCasas() {
//        List<Casas> casas = new ArrayList<>();
//
//        try {
//            String sql = "SELECT * FROM casas WHERE fecha_desde"
// + " <= '2020-08-31' AND fecha_hasta >= '2020-08-01' AND pais = 'Reino Unido';";
//            PreparedStatement statement = conexion.prepareStatement(sql);
//            ResultSet resultado = statement.executeQuery();
//
//            while (resultado.next()) {
//                Casas casa = new Casas();
//                casa.setId_casa(resultado.getInt("id_casa"));
//                casa.setCalle(resultado.getString("calle"));
//                casa.setCodigo_postal(resultado.getString("codigo_postal"));
//                casa.setCiudad(resultado.getString("ciudad"));
//                casa.setPais(resultado.getString("pais"));
//                casa.setNumero(resultado.getInt("numero"));
//                casa.setTiempo_minimo(resultado.getInt("tiempo_minimo"));
//                casa.setFecha_desde(resultado.getDate("fecha_desde"));
//                casa.setFecha_hasta(resultado.getDate("fecha_hasta"));
//                casa.setTiempo_maximo(resultado.getInt("tiempo_maximo"));
//                casa.setPrecio_habitacion(resultado.getDouble("precio_habitacion"));
//                casa.setTipo_vivienda(resultado.getString("tipo_vivienda"));
//
//                casas.add(casa);
//            }
//        for (Casas  aux : casas) {
//            System.out.println(aux.toString());
//       
//        }    
//            resultado.close();
//            statement.close();
//        } catch (Exception e) {
//            System.out.println("ERROR al listar las casas: " + e.getMessage());
//        }
//
//        return casas;
//    }
//     public List<Casas> listarCasasd() {
//        List<Casas> casas = new ArrayList<>();
//
//        try {
//            String sql = "SELECT *\n" +
//"FROM familias\n" + "WHERE email LIKE '%@hotmail.com';";
//            PreparedStatement statement = conexion.prepareStatement(sql);
//            ResultSet resultado = statement.executeQuery();
//
//            while (resultado.next()) {
//                Casas casa = new Casas();
//                casa.setId_casa(resultado.getInt("id_casa"));
//                casa.setCalle(resultado.getString("calle"));
//                casa.setCodigo_postal(resultado.getString("codigo_postal"));
//                casa.setCiudad(resultado.getString("ciudad"));
//                casa.setPais(resultado.getString("pais"));
//                casa.setNumero(resultado.getInt("numero"));
//                casa.setTiempo_minimo(resultado.getInt("tiempo_minimo"));
//                casa.setFecha_desde(resultado.getDate("fecha_desde"));
//                casa.setFecha_hasta(resultado.getDate("fecha_hasta"));
//                casa.setTiempo_maximo(resultado.getInt("tiempo_maximo"));
//                casa.setPrecio_habitacion(resultado.getDouble("precio_habitacion"));
//                casa.setTipo_vivienda(resultado.getString("tipo_vivienda"));
//
//                casas.add(casa);
//            }
//        for (Casas  aux : casas) {
//            System.out.println(aux.toString());
//       
//        }    
//            resultado.close();
//            statement.close();
//        } catch (Exception e) {
//            System.out.println("ERROR al listar las casas: " + e.getMessage());
//        }
//
//        return casas;
////    }
//
//        CasasDAO casasDAO = new CasasDAO();
//   
//
//    public void insertarCasa(Casas casa) {
//        try {
//            casasDAO.insertarCasa(casa);
//            System.out.println("Casa insertada exitosamente");
//        } catch (Exception e) {
//            System.out.println("Error al insertar la casa: " + e.getMessage());
//        }
//    }
//
//    public void actualizarCasa(Casas casa) {
//        try {
//            casasDAO.actualizarCasa(casa);
//            System.out.println("Casa actualizada exitosamente");
//        } catch (Exception e) {
//            System.out.println("Error al actualizar la casa: " + e.getMessage());
//        }
//    }
//
//    public void eliminarCasa(int idCasa) {
//        try {
//            casasDAO.eliminarCasa(idCasa);
//            System.out.println("Casa eliminada exitosamente");
//        } catch (Exception e) {
//            System.out.println("Error al eliminar la casa: " + e.getMessage());
//        }
//    }
//
//    public Casas obtenerCasaPorId(int idCasa) {
//        try {
//            return casasDAO.obtenerCasaPorId(idCasa);
//        } catch (Exception e) {
//            System.out.println("Error al obtener la casa por ID: " + e.getMessage());
//            return null;
//        }
//    }
//
//    public List<Casas> obtenerTodasLasCasas() {
//        try {
//            return casasDAO.obtenerTodasLasCasas();
//        } catch (Exception e) {
//            System.out.println("Error al obtener todas las casas: " + e.getMessage());
//            return null;
//        }
//    }



