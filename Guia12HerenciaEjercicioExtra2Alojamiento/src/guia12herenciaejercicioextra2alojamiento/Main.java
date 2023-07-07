/*
Una compañía de promociones turísticas desea mantener información sobre la
infraestructura de alojamiento para turistas, de forma tal que los clientes puedan
planear sus vacaciones de acuerdo a sus posibilidades. Los alojamientos se
identifican por un nombre, una dirección, una localidad y un gerente encargado
del lugar. La compañía trabaja con dos tipos de alojamientos: Hoteles y
Alojamientos Extrahoteleros.
Los Hoteles tienen como atributos: Cantidad de Habitaciones, Número de Camas,
Cantidad de Pisos, Precio de Habitaciones. Y estos pueden ser de cuatro o cinco
estrellas. Las características de las distintas categorías son las siguientes:
• Hotel **** Cantidad de Habitaciones, Número de camas, Cantidad de Pisos,
Gimnasio, Nombre del Restaurante, Capacidad del Restaurante, Precio de las
Habitaciones.
• Hotel ***** Cantidad de Habitaciones, Número de camas, Cantidad de Pisos,
Gimnasio, Nombre del Restaurante, Capacidad del Restaurante, Cantidad
Salones de Conferencia, Cantidad de Suites, Cantidad de Limosinas, Precio
de las Habitaciones.
Los gimnasios pueden ser clasificados por la empresa como de tipo “A” o de tipo
“B”, de acuerdo a las prestaciones observadas. Las limosinas están disponibles
para cualquier cliente, pero sujeto a disponibilidad, por lo que cuanto más
limosinas tenga el hotel, más caro será.
El precio de una habitación debe calcularse de acuerdo a la siguiente fórmula:
PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por
restaurante) + (valor agregado por gimnasio) + (valor agregado por limosinas).
Donde:
Valor agregado por el restaurante:

14

• $10 si la capacidad del restaurante es de menos de 30 personas.
• $30 si está entre 30 y 50 personas.
• $50 si es mayor de 50.
Valor agregado por el gimnasio:
• $50 si el tipo del gimnasio es A.
• $30 si el tipo del gimnasio es B.
Valor agregado por las limosinas:
• $15 por la cantidad de limosinas del hotel.
En contraste, los Alojamientos Extra hoteleros proveen servicios diferentes a los
de los hoteles, estando más orientados a la vida al aire libre y al turista de bajos
recursos. Por cada Alojamiento Extrahotelero se indica si es privado o no, así
como la cantidad de metros cuadrados que ocupa. Existen dos tipos de
alojamientos extrahoteleros: los Camping y las Residencias. Para los Camping se
indica la capacidad máxima de carpas, la cantidad de baños disponibles y si
posee o no un restaurante dentro de las instalaciones. Para las residencias se
indica la cantidad de habitaciones, si se hacen o no descuentos a los gremios y
si posee o no campo deportivo. Realizar un programa en el que se representen
todas las relaciones descriptas.
Realizar un sistema de consulta que le permite al usuario consultar por diferentes
criterios:
• todos los alojamientos.
• todos los hoteles de más caro a más barato.
• todos los campings con restaurante
• todas las residencias que tienen descuento.
 */
package guia12herenciaejercicioextra2alojamiento;

import Entidad.Alojamiento;
import Entidad.Camping;
import Entidad.Hotel;
import Entidad.HotelCincoEstrellas;
import Entidad.HotelCuatroEstrellas;
import Entidad.Residencia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Main {
    public static void main(String[] args) {
        List<Alojamiento> alojamientos = new ArrayList<>();

        // Crear instancias de hoteles y alojamientos extrahoteleros
        HotelCuatroEstrellas hotel1 = new HotelCuatroEstrellas("Hotel A", "Dirección A", "Localidad A",
                "Gerente A", 100, 200, 10, true, "Restaurante A", 50);
        HotelCincoEstrellas hotel2 = new HotelCincoEstrellas("Hotel B", "Dirección B", "Localidad B",
                "Gerente B", 200, 400, 20, true, "Restaurante B", 100, 5, 10, 3);
        Camping camping1 = new Camping("Camping A", "Dirección C", "Localidad C",
                "Gerente C", 50, 10, true);
        Camping camping2 = new Camping("Camping B", "Dirección D", "Localidad D",
                "Gerente D", 30, 5, false);
        Residencia residencia1 = new Residencia(100, false, true,"StarsWars","Rodriguez", "Lomas de Zamora","Santin",false, 50);
        Residencia residencia2 = new Residencia(50, true, false,"King Ceaser","Espronceda", "Lomas de Zamora","Santin",false, 50);

        // Agregar los alojamientos a la lista
        alojamientos.add(hotel1);
        alojamientos.add(hotel2);
        alojamientos.add(camping1);
        alojamientos.add(camping2);
        alojamientos.add(residencia1);
        alojamientos.add(residencia2);

        // Consulta: Todos los alojamientos
        System.out.println("Consulta: Todos los alojamientos");
        for (Alojamiento alojamiento : alojamientos) {
            System.out.println("Nombre: " + alojamiento.nombre);
            System.out.println("Dirección: " + alojamiento.direccion);
            System.out.println("Localidad: " + alojamiento.localidad);
            System.out.println("Gerente: " + alojamiento.gerente);
            System.out.println("-----------------------");
        }

        // Consulta: Todos los hoteles de más caro a más barato
        System.out.println("Consulta: Todos los hoteles de más caro a más barato");
        Collections.sort(alojamientos, new Comparator<Alojamiento>() {
            @Override
            public int compare(Alojamiento a1, Alojamiento a2) {
                double precio1 = a1.calcularPrecioHabitacion();
                double precio2 = a2.calcularPrecioHabitacion();
                return Double.compare(precio2, precio1);
            }
        });
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel) {
                System.out.println("Nombre: " + alojamiento.nombre);
                System.out.println("Precio Habitación: " + alojamiento.calcularPrecioHabitacion());
                System.out.println("-----------------------");
            }
        }

        // Consulta: Todos los campings con restaurante
        System.out.println("Consulta: Todos los campings con restaurante");
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Camping) {
                Camping camping = (Camping) alojamiento;
                if (camping.restaurante) {
                    System.out.println("Nombre: " + alojamiento.nombre);
                    System.out.println("Dirección: " + alojamiento.direccion);
                    System.out.println("Localidad: " + alojamiento.localidad);
                    System.out.println("Gerente: " + alojamiento.gerente);
                    System.out.println("-----------------------");
                }
            }
        }

        // Consulta: Todas las residencias que tienen descuento
        System.out.println("Consulta: Todas las residencias que tienen descuento");
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Residencia) {
                Residencia residencia = (Residencia) alojamiento;
                if (residencia.descuento) {
                    System.out.println("Nombre: " + alojamiento.nombre);
                    System.out.println("Dirección: " + alojamiento.direccion);
                    System.out.println("Localidad: " + alojamiento.localidad);
                    System.out.println("Gerente: " + alojamiento.gerente);
                    System.out.println("-----------------------");
                }
            }
        }
    }
}