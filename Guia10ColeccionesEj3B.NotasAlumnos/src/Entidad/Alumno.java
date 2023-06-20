/*
3 - Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
*/

package Entidad;
import java.util.*;

public class Alumno {
    private String nombre;
    private ArrayList<Integer> notas = new ArrayList();
    
    public Alumno() {
    }

    public Alumno(String nombre, ArrayList<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }
    
    ////
    public Integer getNota(Integer nota) {
        return notas.get(nota);
    }

    public void addNota(Integer nota) {
        notas.add(nota);
    }
    ////
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", notas=" + notas + '}';
    }

    


   
    

}
