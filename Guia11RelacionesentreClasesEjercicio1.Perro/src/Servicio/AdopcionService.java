/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Perro;
import Entidad.Persona;

/**
 *
 * @author RobAre
 */
public class AdopcionService {
    
    public void adoptarPerro(Persona persona, Perro perro) {
        persona.perro = perro;
    }
}