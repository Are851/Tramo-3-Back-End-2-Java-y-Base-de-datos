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
public class Carta {
    private String palo;
    private Integer numero;

    public Carta() {
    }

    public Carta(String palo, Integer numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Carta{" + "palo=" + palo + ", numero=" + numero + '}';
    } 
}