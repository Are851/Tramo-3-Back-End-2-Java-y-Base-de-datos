/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Yate extends Barco {
    private double potenciaCV;
    private int numCamarotes;

    public Yate(String matricula, double eslora, int anioFabricacion, double potenciaCV, int numCamarotes) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaCV = potenciaCV;
        this.numCamarotes = numCamarotes;
    }

    public double calcularModulo() {
        return calcularModulo() + potenciaCV + numCamarotes;
    }

}



