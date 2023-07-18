package persistencia;

import entidades.Fabricante;

public class FabricanteDAO extends DAO{

//g) Ingresar un fabricante a la base de datos
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        String sql = "INSERT INTO fabricante (nombre) VALUES ('" + fabricante.getNombre() + "')";
        insertarModificarEliminar(sql);
    }
}
