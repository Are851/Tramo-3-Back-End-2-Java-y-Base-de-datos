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

public class Revolver {

    private int posicionActual;
    private int posicionAgua;

    public Revolver() {
        this.posicionActual = 1;
        Random random = new Random();
        this.posicionAgua = random.nextInt(6) + 1;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(int posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    public void llenarRevolver() {
        Random random = new Random();
        this.posicionActual = random.nextInt(6) + 1;
        this.posicionAgua = random.nextInt(6) + 1;
    }

    public boolean mojar() {
        if (this.posicionActual == this.posicionAgua) {
            return true;
        } else {
            return false;
        }
    }

    public void siguienteChorro() {
        if (this.posicionActual == 6) {
            this.posicionActual = 1;
        } else {
            this.posicionActual++;
        }
    }
}
