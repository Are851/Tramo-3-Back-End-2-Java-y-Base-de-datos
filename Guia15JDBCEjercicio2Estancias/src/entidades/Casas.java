package entidades;
/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
import java.sql.Date;

public class Casas {

    private String calle,codigo_postal,ciudad,pais;
    private int id_casa,numero,tiempo_minimo;
    private Date fecha_desde;
    private Date fecha_hasta;
    private int tiempo_maximo;
    private double precio_habitacion;
    private String tipo_vivienda;

    public Casas() {
    }

    public Casas(String calle, String codigo_postal, String ciudad, String pais, int id_casa, int numero, int tiempo_minimo, Date fecha_desde, Date fecha_hasta, int tiempo_maximo, double precio_habitacion, String tipo_vivienda) {
        this.calle = calle;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.id_casa = id_casa;
        this.numero = numero;
        this.tiempo_minimo = tiempo_minimo;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.tiempo_maximo = tiempo_maximo;
        this.precio_habitacion = precio_habitacion;
        this.tipo_vivienda = tipo_vivienda;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTiempo_minimo() {
        return tiempo_minimo;
    }

    public void setTiempo_minimo(int tiempo_minimo) {
        this.tiempo_minimo = tiempo_minimo;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public int getTiempo_maximo() {
        return tiempo_maximo;
    }

    public void setTiempo_maximo(int tiempo_maximo) {
        this.tiempo_maximo = tiempo_maximo;
    }

    public double getPrecio_habitacion() {
        return precio_habitacion;
    }

    public void setPrecio_habitacion(double precio_habitacion) {
        this.precio_habitacion = precio_habitacion;
    }

    public String getTipo_vivienda() {
        return tipo_vivienda;
    }

    public void setTipo_vivienda(String tipo_vivienda) {
        this.tipo_vivienda = tipo_vivienda;
    }

    @Override
    public String toString() {
        return "Casas disponibles" + "\ncalle=" + calle + "\ncodigo_postal=" + codigo_postal
    + "\nciudad=" + ciudad + "\npais=" + pais + "\nid_casa=" + id_casa + "\nnumero=" 
    + numero + "\ntiempo_minimo=" + tiempo_minimo + "\nfecha_desde=" + fecha_desde + 
    "\nfecha_hasta=" + fecha_hasta + "\ntiempo_maximo=" + tiempo_maximo + 
    "\nprecio_habitacion=" + precio_habitacion + "\ntipo_vivienda=" +
    tipo_vivienda + '\n';
}
    }