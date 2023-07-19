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
import entidades.comentarios;

public class comentariosDAO extends DAO {

    public ArrayList<comentarios> listarComentarios() throws Exception {
        String sql = "SELECT * FROM comentarios";
        ArrayList<comentarios> listaComentarios = new ArrayList<>();

        try {
            consultarBase(sql);
            while (resultado.next()) {
                comentarios comentario = new comentarios();
                comentario.setId_comentario(resultado.getInt("id_comentario"));
                comentario.setComentario(resultado.getString("comentario"));
                comentario.setId_casa(resultado.getInt("id_casa"));
                listaComentarios.add(comentario);
            }
        } catch (Exception e) {
            System.out.println("ERROR en listarComentarios: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }

        return listaComentarios;
    }

    public void agregarComentario(comentarios comentario) throws Exception {
        String sql = "INSERT INTO comentarios (comentario, id_casa) VALUES ('" + comentario.getComentario() + "', " + comentario.getId_casa() + ")";

        try {
            insertarModificarEliminar(sql);
            System.out.println("Comentario agregado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al agregar comentario: " + e.getMessage());
            throw e;
        }
    }

    public void eliminarComentario(int idComentario) throws Exception {
        String sql = "DELETE FROM comentarios WHERE id_comentario = " + idComentario;

        try {
            insertarModificarEliminar(sql);
            System.out.println("Comentario eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al eliminar comentario: " + e.getMessage());
            throw e;
        }
    }
}
