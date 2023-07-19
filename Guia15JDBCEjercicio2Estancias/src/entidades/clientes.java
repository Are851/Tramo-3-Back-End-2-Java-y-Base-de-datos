/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class clientes {

    private int id_cliente, numero;
    private String nombre, calle, codigo_postal,ciudad, pais,email;
    
    public clientes() {
    }

    public clientes(int id_cliente, int numero, String nombre, String calle, String codigo_postal, String ciudad, String pais, String email) {
        this.id_cliente = id_cliente;
        this.numero = numero;
        this.nombre = nombre;
        this.calle = calle;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nClientes" + "\nid_cliente=" + id_cliente + ", \nnumero=" + numero +
    "\nnombre=" + nombre + "\ncalle=" + calle + "\ncodigo_postal=" 
    + codigo_postal + "\nciudad=" + ciudad + "\npais=" + pais
    + "\nemail=" + email +  + '\n';
    }
}