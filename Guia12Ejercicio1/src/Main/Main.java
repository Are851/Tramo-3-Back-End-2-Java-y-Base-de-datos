/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Animal;
import Entidad.Caballo;
import Entidad.Gato;
import Entidad.Perro;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Main {

    public static void main(String[] args) {
        Animal animal1 = new Perro("Max", "croquetas", 5, "Labrador");
        Animal animal2 = new Gato("Luna", "pescado", 3, "Siames");
        Animal animal3 = new Caballo("Spirit", "pasto", 8, "Frisón");

        animal1.alimentarse();
        animal2.alimentarse();
        animal3.alimentarse();
    }
}

