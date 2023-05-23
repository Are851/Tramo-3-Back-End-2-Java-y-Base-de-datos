/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entidad.Perro;
import Entidad.Persona;

public class ProgramaAdopcion {
    
    public static void main(String[] args) {
        // Crear dos personas
        Persona persona1 = new Persona();
        persona1.setNombre("Juan") ;
        persona1.setApellido("Pérez");
        persona1.setEdad(30);
        persona1.setDocumento(12345678);

        Persona persona2 = new Persona();
        persona2.setNombre("María");
        persona2.setApellido("López");
        persona2.setEdad(25);
        persona2.setDocumento(98765432);

        // Crear dos perros
        Perro perro1 = new Perro();
        perro1.setNombre("Max");
        perro1.setRaza("Labrador");
        perro1.setEdad(3);
        perro1.setTamaño("Grande");

        Perro perro2 = new Perro();
        perro2.setNombre("Luna");
        perro2.setRaza( "Golden Retriever");
        perro2.setEdad(2);
        perro2.setTamaño( "Mediano");

        // Servicio de adopción
        AdopcionService adopcionService = new AdopcionService();

        // Asignar perros a las personas
        adopcionService.adoptarPerro(persona1, perro1);
        adopcionService.adoptarPerro(persona2, perro2);

        // Mostrar información de las personas y los perros
        System.out.println("Información de la Persona 1:");
        mostrarInformacionPersona(persona1);
        System.out.println();

        System.out.println("Información de la Persona 2:");
        mostrarInformacionPersona(persona2);
    }

    public static void mostrarInformacionPersona(Persona persona) {
        System.out.println(persona.toString());
       
        if (persona.perro != null) {
            System.out.println("--- Información del Perro ---");
            System.out.println(persona.perro.toString());

        } else {
            System.out.println("No se ha asignado ningún perro a esta persona.");
        }
    }

    private static class AdopcionService {

        public void adoptarPerro(Persona persona, Perro perro) {
        persona.perro = perro;
    }
        }
   }
