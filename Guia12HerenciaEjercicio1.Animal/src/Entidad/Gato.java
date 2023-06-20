/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *  <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

public class Gato extends Animal {
    public Gato(String nombre, String alimento, int edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

    @Override
    public void alimentarse() {
        System.out.println("El gato " + getNombre() + " se alimenta de " + getAlimento());
    }
}