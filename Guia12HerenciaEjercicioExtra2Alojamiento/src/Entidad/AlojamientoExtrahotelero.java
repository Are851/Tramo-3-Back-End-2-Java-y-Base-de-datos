/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public  class AlojamientoExtrahotelero extends Alojamiento {
    protected boolean privado;
    protected double metrosCuadrados;

    public AlojamientoExtrahotelero(String nombre, String direccion, String localidad, String gerente,
                                    boolean privado, double metrosCuadrados) {
        super(nombre, direccion, localidad, gerente);
        this.privado = privado;
        this.metrosCuadrados = metrosCuadrados;
    }

    // Resto de atributos y métodos de AlojamientoExtrahotelero

    @Override
    public double calcularPrecioHabitacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 

