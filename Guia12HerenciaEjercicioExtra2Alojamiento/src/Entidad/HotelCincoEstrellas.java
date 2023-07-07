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
public class HotelCincoEstrellas extends Hotel {
    protected int cantidadSalonesConferencia;
    protected int cantidadSuites;
    protected int cantidadLimosinas;

    public HotelCincoEstrellas(String nombre, String direccion, String localidad, String gerente,
                               int cantidadHabitaciones, int numeroCamas, int cantidadPisos,
                               boolean gimnasio, String nombreRestaurante, int capacidadRestaurante,
                               int cantidadSalonesConferencia, int cantidadSuites, int cantidadLimosinas) {
        super(nombre, direccion, localidad, gerente, cantidadHabitaciones, numeroCamas, cantidadPisos,
                gimnasio, nombreRestaurante, capacidadRestaurante);
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
        this.cantidadSuites = cantidadSuites;
        this.cantidadLimosinas = cantidadLimosinas;
    }

    @Override
    public double valorAgregadoGimnasio() {
        return gimnasio ? 50 : 30;
    }

    @Override
    public double valorAgregadoLimosinas() {
        return 15 * cantidadLimosinas;
    }
}

