/*
Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta 
página: https://mapanet.eu/index.htm. 
Nota: Poner el código postal sin la letra,solo el numero. 
• Pedirle al usuario que ingrese 10 códigos postales y sus ciudades. 
• Muestra por pantalla los datos introducidos 
• Pide un código postal y muestra la ciudad asociada si existe sino avisa al 
usuario. 
• Muestra por pantalla los datos 
• Agregar una ciudad con su código postal correspondiente más al HashMap. 
• Elimina 3 ciudades existentes dentro del HashMap
 */
package Entidad;

/**
 *
 * @author RobAre
 */

public class Ciudad {
    private int codigoPostal;
    private String nombre;

    public Ciudad(int codigoPostal, String nombre) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Código Postal: " + codigoPostal + ", Ciudad: " + nombre;
    }
}