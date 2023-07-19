package entidades;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
import java.time.LocalDate;

/**
 *
 * @author no_de
 */
public class Estancias {

    int id_estancia;
    private int id_cliente, id_casa;
    private String nombre_huesped;
    private LocalDate fecha_desde;
    private LocalDate fecha_hasta;

    public Estancias() {
    }

    public int getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public LocalDate getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(LocalDate fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public LocalDate getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(LocalDate fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public Estancias(int id_estancia, int id_cliente, int id_casa, String nombre_huesped, LocalDate fecha_desde, LocalDate fecha_hasta) {
        this.id_estancia = id_estancia;
        this.id_cliente = id_cliente;
        this.id_casa = id_casa;
        this.nombre_huesped = nombre_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    @Override
    public String toString() {
        return "Estancias{" + "\nid_estancia=" + id_estancia + "\nidv_cliente="
        + id_cliente + "\nid_casa=" + id_casa + "\nnombre_huesped=" + nombre_huesped + 
        "\nfecha_desde=" + fecha_desde + ", fecha_hasta=" + fecha_hasta + '\n';
    
}}    