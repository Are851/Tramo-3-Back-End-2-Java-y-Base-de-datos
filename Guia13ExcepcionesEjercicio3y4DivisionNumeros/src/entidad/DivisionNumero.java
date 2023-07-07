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
package entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */


public class DivisionNumero {

    public static int dividirNumeros(int num1, int num2) throws Exception {
        
        return num1 / num2;
    }
}