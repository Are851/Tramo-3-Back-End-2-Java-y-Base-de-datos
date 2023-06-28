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

   public class Generador extends Dispositivo{
    
    protected float energiaTotal;
    protected float energiaTT;
    // ESTADO :
    // True : reparado
    // False : dañado

    public Generador() {
    }

    public Generador(float energiaTotal, boolean estado) {
        super(estado);
        this.energiaTotal = energiaTotal;
        this.energiaTT = energiaTotal;
    }

    public float getEnergiaTT() {
        return energiaTT;
    }

    public float getEnergiaTotal() {
        return energiaTotal;
    }

    public void setEnergiaTotal(float energiaTotal) {
        this.energiaTotal = energiaTotal;
    }


    @Override
    public String toString() {
        return "Generador{" + "energiaTotal=" + energiaTotal + ", estado=" + estado + '}';
    }
}