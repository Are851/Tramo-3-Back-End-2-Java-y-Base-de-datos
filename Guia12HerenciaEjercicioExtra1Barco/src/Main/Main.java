/*
En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler
se guarda: el nombre, documento del cliente, la fecha de alquiler, fecha de
devolución, la posición del amarre y el barco que lo ocupará.
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de
fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos
especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
Un alquiler se calcula multiplicando el número de días de ocupación (calculado
con la fecha de alquiler y devolución), por un valor módulo de cada barco
(obtenido simplemente multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco, se calcula sacando el
modulo normal y sumándole el atributo particular de cada barco. En los veleros
se suma el número de mástiles, en los barcos a motor se le suma la potencia en
CV y en los yates se suma la potencia en CV y el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las
clases y los métodos necesarios que permitan al usuario elegir el barco que
quiera alquilar y mostrarle el precio final de su alquiler.
 */
package Main;

import entidad.Alquiler;
import entidad.Barco;
import entidad.BarcoAMotor;
import entidad.Velero;
import entidad.Yate;
import java.time.LocalDate;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
  public class Main {
    public static void main(String[] args) {
        Barco barco1 = new Velero("ABC123", 10.5, 2010, 3);
        Barco barco2 = new BarcoAMotor("DEF456", 12.2, 2015, 250.0);
        Barco barco3 = new Yate("GHI789", 15.0, 2018, 350.0, 4);

        Alquiler alquiler1 = new Alquiler("Juan Perez", "12345678", LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 5), 1, barco1);
        Alquiler alquiler2 = new Alquiler("Maria Gomez", "98765432", LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 5), 2, barco2);
        Alquiler alquiler3 = new Alquiler("Pedro Sanchez", "56789012", LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 5), 3, barco3);

        System.out.println("Precio de alquiler 1: " + alquiler1.calcularPrecioAlquiler());
        System.out.println("Precio de alquiler 2: " + alquiler2.calcularPrecioAlquiler());
        System.out.println("Precio de alquiler 3: " + alquiler3.calcularPrecioAlquiler());
    }
   
}
