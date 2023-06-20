/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */

import entidades.Perro;
import entidades.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JosePc
 */
public class MenuPerros {

    Scanner leerNum = new Scanner(System.in);
    Scanner leerTexto = new Scanner(System.in);
    ArrayList<Persona> listaPersonas = new ArrayList<>();
    ArrayList<Perro> listaPerros = new ArrayList<>();
    Persona p = new Persona();
    Perro pe = new Perro();
    
    public void mostrarMenu() {
      
        int opcion;
        do {
            System.out.println("Menu de opciones");
            System.out.println("-------------------------");
            System.out.println("");
            System.out.println("1 - Cargar personas");
            System.out.println("2 - Cargar perros");
            System.out.println("3 - Listar personas");
            System.out.println("4 - Listar perros");
            System.out.println("5 - Asignar perros a personas");
            System.out.println("6 - Salir");
            System.out.println("");
            System.out.println("Ingrese la opción elejida");
            opcion = leerNum.nextInt();

            switch (opcion) {
                case 1:
                    //listaPersonas.add(p.crearPersona());
                    listaPersonas.add(new Persona("Pepe", "Perez", 10, 123456789, null));
                    listaPersonas.add(new Persona("Juan", "Gonzalez", 25, 21456789, null));
                    listaPersonas.add(new Persona("Sebastian", "Silva", 34, 35123456, null));
                    break;

                case 2:
                    //listaPerros.add(pe.crearPerro());
                    listaPerros.add(new Perro("Chiquito", "no se", 10, "gde", false));
                    listaPerros.add(new Perro("Grandecito", "beagle", 5, "chico", false));
                    listaPerros.add(new Perro("Puppy", "mixto", 12, "mediana", false));
                    break;

                case 3:
                    p.listaPersonas(listaPersonas);
                    break;

                case 4:
                    pe.listaPerros(listaPerros);
                    break;
                case 5:
                    asignarPerros();
                    break;

            }
        } while (opcion < 6);

    }

    public void asignarPerros() {
        String perroElegido;
            
        for (Persona p : listaPersonas) {
            System.out.println(p.getNombre() + " te toca adoptar un perro de la lista : \nListado de perros: \n");
            //pe.listaPerros(listaPerros);
            for (Perro pe : listaPerros) {
                if (!pe.isAdoptado())
                    System.out.println(pe.toString());
            }
            System.out.println("--------------");
            System.out.println("Elegí el nombre de un perro: ");
            perroElegido = leerTexto.next();
            for (Perro pe : listaPerros) {
                if (pe.getNombre().equalsIgnoreCase(perroElegido))  {
                    System.out.print("Elegiste a ");
                    pe.toString();
                    
                    p.setPerro(pe);
                    pe.setAdoptado(true);
                    System.out.println("--------------");
                    System.out.println(p.getNombre() + " adoptó a : " + pe.getNombre()+"\n\n");
                    break;
                }
            }
        }
        // mostrarPersonasQueAdoptaron(listaPersonas);
        mostrarPersonasQueAdoptaron();
        
    }
    
    /*
    Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las personas con sus respectivos perros.
    */
    
    //public void mostrarPersonasQueAdoptaron(ArrayList<Persona> listaPersonas) {
    public void mostrarPersonasQueAdoptaron() {
                
        for (Persona p : listaPersonas) {
            if (p.getPerro() != null) {
                System.out.println(p.getNombre() + " " + p.getApellido() + " adoptó a : " + p.getPerro().getNombre());
            }
            
        }
    }
    
}