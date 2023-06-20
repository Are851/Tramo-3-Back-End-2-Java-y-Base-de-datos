/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del
Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá
mostrar luego un mensaje por pantalla informando de que se alimenta.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *  <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

public class Animal {
    private String nombre;
    private String alimento;
    private int edad;
    private String raza;

    public Animal(String nombre, String alimento, int edad, String raza) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlimento() {
        return alimento;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public void alimentarse() {
        System.out.println("El animal se alimenta de " + alimento);
    }
}
