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
public class HotelCuatroEstrellas extends Hotel {
    protected boolean gimnasio;
    protected String nombreRestaurante;
    protected int capacidadRestaurante;

    public HotelCuatroEstrellas(String nombre, String direccion, String localidad, String gerente, int cantidadHabitaciones, int numeroCamas, int cantidadPisos, boolean gimnasio, String nombreRestaurante, int capacidadRestaurante) {
        super(nombre, direccion, localidad, gerente, cantidadHabitaciones, numeroCamas, cantidadPisos, gimnasio, nombreRestaurante, capacidadRestaurante);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
    }

    
    @Override
    protected double valorAgregadoRestaurante() {
        if (capacidadRestaurante < 30) {
            return 10;
        } else if (capacidadRestaurante >= 30 && capacidadRestaurante <= 50) {
            return 30;
        } else {
            return 50;
        }
    }

    @Override
    public double valorAgregadoGimnasio() {
        return gimnasio ? 50 : 0;
    }

    @Override
    public double valorAgregadoLimosinas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


