/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

import entidad.Persona;
import java.util.Scanner;

public class PersonaServicio {

    public boolean esMayorDeEdad(Persona persona) throws Exception {
        if (persona == null) {
            throw new Exception("La persona está mal cargada");
        }
        return persona.getEdad() >= 18;
    }

    public Persona crearPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad:");
        int edad = scanner.nextInt();

        System.out.println("Ingrese el sexo (H - hombre, M - mujer, O - otro):");
        char sexo = scanner.next().toUpperCase().charAt(0);
        while (sexo != 'H' && sexo != 'M' && sexo != 'O') {
            System.out.println("Sexo inválido, ingrese nuevamente (H - hombre, M - mujer, O - otro):");
            sexo = scanner.next().toUpperCase().charAt(0);
        }

        System.out.println("Ingrese el peso (en kg):");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese la altura (en metros):");
        double altura = scanner.nextDouble();

        return new Persona(nombre, edad, sexo, peso, altura);
    }

    public int calcularIMC(Persona persona) {
        double imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }
}
