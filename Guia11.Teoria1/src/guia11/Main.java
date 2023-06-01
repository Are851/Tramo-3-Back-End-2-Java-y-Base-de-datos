/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia11;

import Entidad.Persona;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */


public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona();
 
        p1.setNombre("Alejandro");
        p1.setApellido("Lamas");
        p1.getDni().setNumero(22824814);
        p1.getDni().setLetra('A');
        
        System.out.println(p1.getNombre() + p1.getApellido() + p1.getDni().getLetra() + p1.getDni().getNumero());
        
    }
}