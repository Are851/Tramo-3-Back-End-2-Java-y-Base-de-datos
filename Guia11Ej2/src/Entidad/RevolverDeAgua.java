/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
import java.util.Random;

public class RevolverDeAgua {
    private int posicionActual;
    private int posicionAgua;

    public void llenarRevolver() {
        Random random = new Random();
        posicionActual = random.nextInt(6) + 1;
        posicionAgua = random.nextInt(6) + 1;
    }

    public boolean mojar() {
        return posicionActual == posicionAgua;
    }

    public void siguienteChorro() {
        if (posicionActual == 6) {
            posicionActual = 1;
        } else {
            posicionActual++;
        }
    }

    @Override
    public String toString() {
        return "Revolver de agua [Posición actual: " + posicionActual + ", Posición del agua: " + posicionAgua + "]";
    }
}