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

import Persistencia.EstanciasDAO;
import entidades.Estancias;
import java.util.ArrayList;
import java.util.List;

public class EstanciasServicio {

    private EstanciasDAO estanciasDAO;

    public EstanciasServicio() {
        estanciasDAO  = new EstanciasDAO();
    }

    public void listarEstancias(String opc) {
        try {
          EstanciasDAO estanciasDAO1 = new EstanciasDAO();

          List<Estancias> estancias = estanciasDAO1.listarEstancias(opc);   
        
             for (Estancias aux : estancias) {
             System.out.println(aux.toString());
        } }catch (Exception e) {
            System.out.println("ERROR al listar estancias: " + e.getMessage());
        }
    }
   
    public void agregarEstancia(Estancias estancia) {
        try {
            estanciasDAO.agregarEstancia(estancia);
        } catch (Exception e) {
            System.out.println("ERROR al agregar estancia: " + e.getMessage());
        }
    }

    public void eliminarEstancia(int idEstancia) {
        try {
            estanciasDAO.eliminarEstancia(idEstancia);
        } catch (Exception e) {
            System.out.println("ERROR al eliminar estancia: " + e.getMessage());
        }
    }
}
