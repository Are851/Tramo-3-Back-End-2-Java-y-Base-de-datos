/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JosePc
 */
public class Persona {

    Scanner leerTexto = new Scanner(System.in);
    Scanner leerNum = new Scanner(System.in);

    private String nombre;
    private String apellido;
    private int edad;
    private long documento;
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, long documento, Perro perro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perro = perro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", documento=" + documento + ", perro=" + perro + '}';
    }

    public Persona crearPersona() {
        Persona p = new Persona();

        System.out.println("Ingrese el nombre de la persona: ");
        p.nombre = leerTexto.nextLine();
        System.out.println("Ingrese el apellido de la persona: ");
        p.apellido = leerTexto.nextLine();
        System.out.println("Ingrese la edad de la persona: ");
        p.edad = leerNum.nextInt();
        System.out.println("Ingrese el documento de la persona: ");
        p.documento = leerNum.nextInt();
        p.perro = null;
        return p;

    }

    public void listaPersonas(ArrayList<Persona> listaPersonas) {

        for (Persona p : listaPersonas) {
            System.out.println(p.toString());
        }
    }
}