/* EJERCICIO 3 GUIA 8
Realizar una clase llamada Persona en el paquete de entidades que tengan 
los siguientes atributos: nombre, edad, sexo (‘H’ para hombre, ‘M’ para mujer, 
‘O’ para otro), peso y altura. Si desea añadir algún otro atributo, puede 
hacerlo. Agregar constructores, getters y setters.
En el paquete Servicios crear PersonaServicio con los siguientes 3 métodos:
a) Método esMayorDeEdad(): indica si la persona es mayor de edad. La función 
devuelve un booleano.
b) Metodo crearPersona(): el método crear persona, le pide los valores de los 
atributos al usuario y después se le asignan a sus respectivos atributos 
para llenar el objeto Persona. Además, comprueba que el sexo introducido 
sea correcto, es decir, H, M o O. Si no es correcto se deberá mostrar un mensaje.
c) Método calcularIMC(): calculara si la persona está en su peso ideal (peso en 
kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor menor que 20, 
significa que la persona está por debajo de su peso ideal y la función devuelve 
un -1. Si la fórmula da por resultado un número entre 20 y 25 (incluidos), 
significa que la persona está en su peso ideal y la función devuelve un 0. 
Finalmente, si el resultado de la fórmula es un valor mayor que 25 significa 
que la persona tiene sobrepeso, y la función devuelve un 1.
================================================================================
A continuación, en la clase main hacer lo siguiente:
Crear 4 objetos de tipo Persona con distintos valores, a continuación, 
llamaremos todos los métodos para cada objeto, deberá comprobar si la persona 
está en su peso ideal, tiene sobrepeso o está por debajo de su peso ideal e 
indicar para cada objeto si la persona es mayor de edad.
Por último, guardaremos los resultados de los métodos calcularIMC y 
esMayorDeEdad en distintas variables(arrays), para después calcular un 
porcentaje de esas 4 personas cuantas están por debajo de su peso, cuantas 
en su peso ideal y cuantos, por encima, y también calcularemos un porcentaje 
de cuantos son mayores de edad y cuantos menores. Para esto, podemos crear 
unos métodos adicionales.
================================================================================
//Inicializar un objeto de la clase Persona ejercicio 3 de la guía Servicios, a 
null y tratar de invocar el //método esMayorDeEdad() a través de ese objeto. 
Luego, englobe el código con una cláusula try-catch para probar la nueva 
excepción que debe ser controlada.
 */
package Main;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

import entidad.Persona;
import java.util.Scanner;
import servicio.PersonaServicio;


public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaServicio personaServicio = new PersonaServicio();
        System.out.println("Ingrese cuantas personas desea cargar");
        int N = leer.nextInt();
        Persona[] personas = new Persona[N];
        int[] resultadosIMC = new int[N];
        boolean[] mayoresDeEdad = new boolean[N];

        personas[0] = personaServicio.crearPersona();
        personas[1] = null;

        for (int i = 0; i < N; i++) {
            try {
                mayoresDeEdad[i] = personaServicio.esMayorDeEdad(personas[i]);
                resultadosIMC[i] = personaServicio.calcularIMC(personas[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int porDebajoPeso = 0;
        int enPesoIdeal = 0;
        int conSobrepeso = 0;
        int cantidadMayoresDeEdad = 0;

        for (int i = 0; i < N; i++) {
            switch (resultadosIMC[i]) {
                case -1:
                    porDebajoPeso++;
                    break;
                case 0:
                    enPesoIdeal++;
                    break;
                default:
                    conSobrepeso++;
                    break;
            }
            if (mayoresDeEdad[i]) {
                cantidadMayoresDeEdad++;
            }
        }

        System.out.println("Porcentaje de personas por debajo del peso ideal: " + (porDebajoPeso / N) * 100);
        System.out.println("Porcentaje de personas en su peso ideal: " + (enPesoIdeal / N) * 100);
        System.out.println("Porcentaje de personas con sobrepeso: " + (conSobrepeso / N) * 100);
        System.out.println("Porcentaje de personas mayores de edad: " + (cantidadMayoresDeEdad / N) * 100);
        System.out.println("Porcentaje de personas menores de edad: " + ((4 - cantidadMayoresDeEdad) / N) * 100);
    }
}