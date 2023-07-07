/*
Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de
Electrodomésticos para guardar 4 electrodomésticos, ya sean lavadoras o
televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada
electrodoméstico. Se deberá también mostrar el precio de cada tipo de objeto,
es decir, el precio de todos los televisores y el de las lavadoras. Una vez hecho
eso, también deberemos mostrar, la suma del precio de todos los
Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 2000
y un televisor de 5000, el resultado final será de 7000 (2000+5000)
 */
package Main;
/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */


import Entidad.Electrodomestico;
import Entidad.Lavadora;
import Entidad.Televisor;
import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

        electrodomesticos.add(new Lavadora(40, "blue", 'B', 50, 100));
        electrodomesticos.add(new Televisor(50, "blanco", 'A', 100, 3000, true));
        electrodomesticos.add(new Lavadora(20,"Gris", 'C', 25, 200));
        electrodomesticos.add(new Televisor(60, "negro", 'B', 200, 2000, false));

        double precioTotal = 0;
        double precioLavadoras = 0;
        double precioTelevisores = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            double precioFinal = electrodomestico.precioFinal();
            precioTotal += precioFinal;

            if (electrodomestico instanceof Lavadora) {
                precioLavadoras += precioFinal;
            } else if (electrodomestico instanceof Televisor) {
                precioTelevisores += precioFinal;
            }
        }

        for (Electrodomestico electrodomestico : electrodomesticos) {
            System.out.println("Color: " + electrodomestico.getColor() +
                    ", Consumo Energetico: " + electrodomestico.getConsumoEnergetico() +
                    ", Peso: " + electrodomestico.getPeso() +
                    ", Precio Final: " + electrodomestico.precioFinal());
        }

        System.out.println("Precio de las lavadoras: " + precioLavadoras);
        System.out.println("Precio de los televisores: " + precioTelevisores);
        System.out.println("Precio total de los electrodomésticos: " + precioTotal);
    }
}