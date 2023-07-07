package main;

/**
 * //Excepciones Ejercicio 3
 * Defina una clase llamada DivisionNumero. En el método main utilice un
 * Scanner //para leer dos números en forma de cadena. A continuación, utilice
 * el método parseInt() de la clase Integer, para convertir las cadenas al tipo
 * int y guardarlas en dos variables de tipo int. Por ultimo realizar //una
 * división con los dos numeros y mostrar el resultado.
 * 
 *Excepciones Ejercicio 4
 * Todas estas operaciones puede tirar excepciones a manejar, el ingreso por 
teclado puede causar una excepción de tipo InputMismatchException, el método 
Integer.parseInt() si la cadena no puede convertirse a entero, arroja una 
NumberFormatException y además, al dividir un número por cero surge una 
ArithmeticException. Manipule todas las posibles excepciones utilizando bloques 
try/catch para las distintas excepciones.
*/
 /**
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
import entidad.DivisionNumero;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Por favor, introduce el primer número:");
        String num1Str = scanner.next();

        System.out.println("Por favor, introduce el segundo número:");
        String num2Str = scanner.next();

        int num1, num2;

        try {
            num1 = Integer.parseInt(num1Str);
            num2 = Integer.parseInt(num2Str);

            int resultado = DivisionNumero.dividirNumeros(num1, num2);
            System.out.println("El resultado de la división es: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("No válido: La entrada no es un número válido.");
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
             //CASO B - Preveo lo que puede pasar
//        int numero1 = 10, numero2 = 0; //Modificar numero2 a cero y ver lo que pasa
//        try {
//            int resultado = numero1 / numero2;
//            System.out.println("La division es: " + resultado);
//        } catch (ArithmeticException e) {
//            System.out.println("NO SE PUEDE DIVIDIR POR CERO");
//            System.out.println(e.getMessage());
//        } catch (Exception e) { 
//            System.out.println("Aca ocurrio algo que no tuve en cuenta");           
//        } finally {            
//            System.out.println("FIN PROGRAMA");
//        }
        //CASO C - Ver manejo de que entra un dato Cadena cuando esperaba numero
//        Scanner leer = new Scanner(System.in);
//        System.out.println("Ingrese un numero entero");
//        
//        try {
//            int numeroI = leer.nextInt();
//            System.out.println("El numero ingresado es:" + numeroI);
//        } catch (InputMismatchException e) {
//            System.out.println(e.toString() + e.getMessage()+   " UPS....OCURRIO ALGO INESPERADO");
//        } finally {
//            System.out.println("FIN");
//        }
    }
        }
    }
}
