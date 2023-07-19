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
import Persistencia.familiasDAO;
import entidades.familias;
import java.util.ArrayList;

public class familiasServicio {

    public void listarFamilias(String opc) throws Exception {

        familiasDAO fdao = new familiasDAO();
        ArrayList<familias> familias = new ArrayList();
        if (opc.equals("a")) {
            familias = fdao.listarfamilia(opc);
        }
        if (opc.equals("c")) {
            familias = fdao.listarfamilia(opc);
            }
        if (opc.equals("d")) {
            familias = fdao.listarfamilia(opc);
        }
        for (familias aux : familias) {
            System.out.println(aux.toString());
        }
    }
}
