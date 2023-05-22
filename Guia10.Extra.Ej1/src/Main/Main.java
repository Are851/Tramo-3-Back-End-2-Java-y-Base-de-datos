/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Numeros;
import Servicio.Servicio;

/**
 *
 * @author RobAre
 */
public class Main {
    public static void main(String[] args) {
        Servicio serv=new Servicio();
        Numeros numer=new Numeros();
        serv.cargarNumeros(numer);
        serv.mostrarLista();
        serv.mostrarEstadisticas();
        
    }
}
