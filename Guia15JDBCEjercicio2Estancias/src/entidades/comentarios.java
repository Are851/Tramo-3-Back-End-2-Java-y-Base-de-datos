package entidades;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class comentarios {
    private int id_comentario;
    private String comentario;
    private int id_casa;

    public comentarios() {
    }

    public comentarios(int id_comentario, String comentario, int id_casa) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.id_casa = id_casa;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }
 
}