package persistencia;

import entidades.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void persistirEntidad(Editorial object) {
        super.persistirEntidad(object);
    }

    @Override
    public void actualizarEntidad(Editorial object) {
        super.actualizarEntidad(object);
    }

    @Override
    public void borrarEntidad(Editorial object) {
        super.borrarEntidad(object);
    }

    public Editorial buscarEditorial(Integer id) {
        Editorial editorial = em.find(Editorial.class, id);
        return editorial;
    }
}
