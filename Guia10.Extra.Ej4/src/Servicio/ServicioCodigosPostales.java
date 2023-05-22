/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author RobAre
 */

import Entidad.Ciudad;
import java.util.HashMap;
import java.util.Map;

public class ServicioCodigosPostales {
    private Map<Integer, Ciudad> codigosPostales;

    public ServicioCodigosPostales() {
        this.codigosPostales = new HashMap<>();
    }

    public void agregarCiudad(int codigoPostal, String nombre) {
        Ciudad ciudad = new Ciudad(codigoPostal, nombre);
        codigosPostales.put(codigoPostal, ciudad);
    }

    public Ciudad buscarCiudad(int codigoPostal) {
        return codigosPostales.get(codigoPostal);
    }

    public void eliminarCiudad(int codigoPostal) {
        codigosPostales.remove(codigoPostal);
    }

    public void mostrarCodigosPostales() {
        for (Ciudad ciudad : codigosPostales.values()) {
            System.out.println(ciudad.toString());
        }
    }
}
    

