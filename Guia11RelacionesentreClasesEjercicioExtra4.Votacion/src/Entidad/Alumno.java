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
import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombreCompleto;
    private int DNI;
    private int cantidadVotos;
    private List<Alumno> votos;

    public Alumno(String nombreCompleto, int DNI) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.cantidadVotos = 0;
        this.votos = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getDNI() {
        return DNI;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public List<Alumno> getVotos() {
        return votos;
    }

    public void incrementarVoto() {
        cantidadVotos++;
    }

    public void agregarVoto(Alumno alumno) {
        votos.add(alumno);
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setVotos(List<Alumno> votos) {
        this.votos = votos;
    }
    
}
