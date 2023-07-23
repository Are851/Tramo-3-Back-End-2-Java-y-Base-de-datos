package persistencia;

import entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void persistirEntidad(Autor object) {
        super.persistirEntidad(object);
    }

    @Override
    public void actualizarEntidad(Autor object) {
        super.actualizarEntidad(object);
    }

    @Override
    public void borrarEntidad(Autor object) {
        super.borrarEntidad(object);
    }
    public Autor buscarAutor(Integer id) {
        Autor autor = em.find(Autor.class, id);
        return autor;
    }
}
