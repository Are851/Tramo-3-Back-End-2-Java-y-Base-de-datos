/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
   public final class Botas extends Dispositivo{

    public Botas() {
    }

    
    public Botas(boolean estado) {
        super(estado);
    }

    public int usarBotas() {
        /**
         * Al utilizar un dispositivo existe un 30% de posibilidades de que se
         * dañe
         */
        if (Math.random() <= 0.3) {
            estado = false;
            return consumo;
        } else {
            return consumo;
        }
    }

    @Override
    public String toString() {
        return "Botas{" + "consumo=" + consumo + ", estado=" + estado + '}';
    }
}