/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Scanner;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Lavadora extends Electrodomestico {

    private int carga;

    public Lavadora() {
        super();
        this.carga = 0;
    }

    public Lavadora(int carga, double precio, String color, char consumoEnergetico, double peso) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void crearLavadora() {
        crearElectrodomestico();

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Ingrese la carga de la lavadora: ");
//        String cargaStr = sc.nextLine();
//        carga = Integer.parseInt(cargaStr);
//
//        sc.close();
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
