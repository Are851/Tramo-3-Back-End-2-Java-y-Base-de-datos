/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Random;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Revolver {
    private int posicionActual;
    private int posicionAgua;

    public Revolver() {
    }

    public void llenarRevolver() {
        Random rand = new Random();
        this.posicionActual = rand.nextInt(6) + 1;
        this.posicionAgua = rand.nextInt(6) + 1;
    }

    public boolean mojar() {
        return this.posicionActual == this.posicionAgua;
    }

    public void siguienteChorro() {
        if (this.posicionActual == 6) {
            this.posicionActual = 1;
        } else {
            this.posicionActual++;
        }
    }

    public String toString() {
        return "Revolver [posicionActual=" + posicionActual + ", posicionAgua=" + posicionAgua + "]";
    }
}
