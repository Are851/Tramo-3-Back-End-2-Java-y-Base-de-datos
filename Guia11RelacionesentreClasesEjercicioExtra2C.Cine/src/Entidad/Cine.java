/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
public class Cine {
    private Pelicula pelicula;
    private double precioEntrada;
    private Espectador[][] sala;
    private int filas;
    private int columnas;

    public Cine(Pelicula pelicula, double precioEntrada, int filas, int columnas) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        this.filas = filas;
        this.columnas = columnas;
        this.sala = new Espectador[filas][columnas];
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public Espectador[][] getSala() {
        return sala;
    }

    public void setSala(Espectador[][] sala) {
        this.sala = sala;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    
    }
