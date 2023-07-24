package persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO {

    public void persistirAutor(Autor autor) {
        persisitrEntidad(autor);
    }

    public void actualizarEstadoAutor(Autor autor) {

        actualizarEstadoEntidad(autor);

    }

    public List buscarAutor() {

        return em.createQuery("SELECT a FROM Autor a").getResultList();

    }

    public List<Autor> buscarAutoresPorNombre(String nombre) {
        String jpql = "SELECT a FROM Autor a WHERE a.nombre = :nombre";
        return em.createQuery(jpql, Autor.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
    public List<Autor> mostrarautores() {
        String jpql = "SELECT a FROM Autor a"; // Se debe incluir un alias para la entidad "Autor" (en este caso, "a").
        return em.createQuery(jpql, Autor.class).getResultList(); // Corregir el final de la consulta y la llamada a getResultList().
    }
}
