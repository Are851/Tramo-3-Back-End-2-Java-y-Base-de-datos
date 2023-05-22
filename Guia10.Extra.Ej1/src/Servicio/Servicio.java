/*
Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado
y los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
programa mostrará por pantalla el número de valores que se han leído, su suma y su
media (promedio).
 */
package Servicio;

import Entidad.Numeros;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RobAre
 */
public class Servicio {

    Scanner leer = new Scanner(System.in);

    ArrayList<Integer> ingnumeros = new ArrayList<>();

    public void cargarNumeros(Numeros numer) {
        int numeros = 0;
        do {
            System.out.println("Ingrese el numero");
            numeros = leer.nextInt();
//        ArrayList<Integer> notas = new ArrayList<>();

            for (Integer number : ingnumeros) {
                ingnumeros.add(number);
            }
        } while (numeros > -99);
    }

    public void mostrarLista() {
        for (Integer number1 : ingnumeros) {
            System.out.println("number1");
        }
    }
     public void mostrarEstadisticas() {
        int cantidadValores = ingnumeros.size();
        System.out.println("Cantidad de valores leídos: " + cantidadValores);

        int suma = 0;
        for (int num : ingnumeros) {
            suma += num;
        }
        System.out.println("Suma de los valores: " + suma);

        double media = (double) suma / cantidadValores;
        System.out.println("Media de los valores: " + media);
    }
    
}



