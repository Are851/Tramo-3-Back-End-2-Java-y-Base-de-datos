/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *  <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Lavadora extends Electrodomestico {
    private double carga;

    public Lavadora() {
        super();
        this.carga = 5;
    }

    public Lavadora(double precio, String color, char consumoEnergetico, double peso, double carga) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public Lavadora(int i, String gris, char c, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public void crearLavadora() {
        crearElectrodomestico();
        // Solicitar información adicional al usuario y llenar el atributo carga
        // Aquí puedes implementar tu código para solicitar los datos al usuario
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += 500;
        }

        return precioFinal;
    }


    
}

