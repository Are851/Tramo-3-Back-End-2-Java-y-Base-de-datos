package persistencia;

import entidades.Libro;

public class LibroDAO extends DAO<Libro> {

    @Override
    public void persistirEntidad(Libro object) {
        super.persistirEntidad(object);
    }

    @Override
    public void actualizarEntidad(Libro object) {
        super.actualizarEntidad(object);
    }

    @Override
    public void borrarEntidad(Libro object) {
        super.borrarEntidad(object);
    }

    public Libro buscarLibroId(Long id) {
        Libro libro = em.find(Libro.class, id);
        return libro;
    }
}
