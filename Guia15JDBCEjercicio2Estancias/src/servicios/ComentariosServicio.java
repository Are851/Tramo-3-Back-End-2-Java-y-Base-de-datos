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
import entidades.comentarios;
import Persistencia.comentariosDAO;
import java.util.ArrayList;

public class ComentariosServicio {
    
    public void listarComentarios() throws Exception {
        comentariosDAO cdao = new comentariosDAO();
        ArrayList<comentarios> comentarios;
        comentarios = cdao.listarComentarios();
        
        for (comentarios c : comentarios) {
            System.out.println(c.toString());
        }
    }
}