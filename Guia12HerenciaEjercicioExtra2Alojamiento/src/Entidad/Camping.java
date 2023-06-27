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
public class Camping extends Alojamiento {
    protected int capacidadMaximaCarpas;
    protected int cantidadBanos;
    public boolean restaurante;

    public Camping(String nombre, String direccion, String localidad, String gerente,
                   int capacidadMaximaCarpas, int cantidadBanos, boolean restaurante) {
        super(nombre, direccion, localidad, gerente);
        this.capacidadMaximaCarpas = capacidadMaximaCarpas;
        this.cantidadBanos = cantidadBanos;
        this.restaurante = restaurante;
    }

    @Override
    public double calcularPrecioHabitacion() {
        return 0; // Precio no aplicable para campings
    }
}

