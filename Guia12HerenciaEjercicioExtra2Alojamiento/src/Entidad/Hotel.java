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
public abstract class Hotel extends Alojamiento {
    protected int cantidadHabitaciones;
    protected int numeroCamas;
    protected int cantidadPisos;
    protected boolean gimnasio;
    protected String nombreRestaurante;
    protected int capacidadRestaurante;

    public Hotel(String nombre, String direccion, String localidad, String gerente,
                 int cantidadHabitaciones, int numeroCamas, int cantidadPisos,
                 boolean gimnasio, String nombreRestaurante, int capacidadRestaurante) {
        super(nombre, direccion, localidad, gerente);
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.numeroCamas = numeroCamas;
        this.cantidadPisos = cantidadPisos;
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
    }

    public abstract double valorAgregadoGimnasio();
    public abstract double valorAgregadoLimosinas();

    @Override
    public double calcularPrecioHabitacion() {
        double precio = 50 + (1 * capacidadRestaurante)
                + valorAgregadoRestaurante() + valorAgregadoGimnasio() + valorAgregadoLimosinas();
        return precio;
    }

    protected double valorAgregadoRestaurante() {
        if (capacidadRestaurante < 30) {
            return 10;
        } else if (capacidadRestaurante >= 30 && capacidadRestaurante <= 50) {
            return 30;
        } else {
            return 50;
        }
    }
}
