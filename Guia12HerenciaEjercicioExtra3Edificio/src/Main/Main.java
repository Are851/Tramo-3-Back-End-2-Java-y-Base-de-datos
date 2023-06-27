/*
Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y
largo. La clase edificio tendrá como métodos:
• Método calcularSuperficie(): calcula la superficie del edificio.
• Método calcularVolumen(): calcula el volumen del edifico.
Estos métodos serán abstractos y los implementarán las siguientes clases:
• Clase Polideportivo con su nombre y tipo de instalación que puede ser
Techado o Abierto, esta clase implementará los dos métodos abstractos y los
atributos del padre.
• Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de
personas por oficina y numero de pisos. Esta clase implementará los dos
métodos abstractos y los atributos del padre.
De esta clase nos interesa saber cuantas personas pueden trabajar en todo el
edificio, el usuario dirá cuantas personas entran en cada oficina, cuantas
oficinas y el numero de piso (suponiendo que en cada piso hay una oficina).
Crear el método cantPersonas(), que muestre cuantas personas entrarían en
un piso y cuantas en todo el edificio.
Por ultimo, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe
contener dos polideportivos y dos edificios de oficinas. Luego, recorrer este array
y ejecutar los métodos calcularSuperficie y calcularVolumen en cada Edificio. Se
deberá mostrar la superficie y el volumen de cada edificio.
Además de esto, para la clase Polideportivo nos interesa saber cuantos
polideportivos son techados y cuantos abiertos. Y para la clase EdificioDeOficinas
deberemos llamar al método cantPersonas() y mostrar los resultados de cada
edificio de oficinas.
 */
package Main;

import entidad.Edificio;
import entidad.Polideportivo;
import java.util.ArrayList;
import entidad.EdificiodeOficinas;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Edificio> edificios = new ArrayList<>();

        // Crear polideportivos
        Polideportivo polideportivo1 = new Polideportivo(50, 30, 20, "Polideportivo 1", "Techado");
        Polideportivo polideportivo2 = new Polideportivo(40, 25, 15, "Polideportivo 2", "Abierto");

        edificios.add(polideportivo1);
        edificios.add(polideportivo2);

        // Crear edificios de oficinas
        EdificiodeOficinas edificioOficinas1 = new EdificiodeOficinas(40, 50, 30, 5, 10, 4);
        EdificiodeOficinas edificioOficinas2 = new EdificiodeOficinas(50, 60, 35, 8, 12, 6);

        edificios.add(edificioOficinas1);
        edificios.add(edificioOficinas2);

        // Calcular superficie y volumen de cada edificio
        for (Edificio edificio : edificios) {
            System.out.println("Superficie del edificio: " + edificio.calcularSuperficie());
            System.out.println("Volumen del edificio: " + edificio.calcularVolumen());
        }

        // Contar polideportivos techados y abiertos
        int polideportivosTechados = 0;
        int polideportivosAbiertos = 0;

        for (Edificio edificio : edificios) {
            if (edificio instanceof Polideportivo) {
                Polideportivo polideportivo = (Polideportivo) edificio;
                if (polideportivo.getTipoInstalacion().equals("Techado")) {
                    polideportivosTechados++;
                } else {
                    polideportivosAbiertos++;
                }
            }
        }

        System.out.println("Polideportivos techados: " + polideportivosTechados);
        System.out.println("Polideportivos abiertos: " + polideportivosAbiertos);

        // Mostrar cantidad de personas en los edificios de oficinas
        edificioOficinas1.cantPersonas();
        edificioOficinas2.cantPersonas();
    }
}