package Main;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
 /**
//         * Nos han pedido que hagamos una aplicación Java de consola para una
//         * pequeña empresa que se dedica a organizar estancias en el extranjero
//         * dentro de una familia. El objetivo es el desarrollo del sistema de
//         * reserva de casas para realizar estancias en el exterior, utilizando
//         * el lenguaje JAVA, una base de datos MySQL y JDBC para realizar la
//         * ejecución de operaciones sobre la base de datos (BD).
//         */
//        /*
//        Realizar un menú en java a través del cual se permita elegir qué consulta se desea realizar. 
//        Las consultas a realizar sobre la BD son las siguientes:
//        a) Listar aquellas familias que tienen al menos 3 hijos, y con edad 
//        máxima inferior a 10 años.
//        b) Buscar y listar las casas disponibles para el periodo comprendido 
//        entre el 1 de agosto de  2020 y el 31 de agosto de 2020 en Reino Unido.
//        c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
//        d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada 
//        y un número de días específico.
//        e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la 
//        descripción de la casa donde la realizaron.
//        17
//        f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y 
//        ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a 
//        la anterior
//        g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el 
//        precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios 
//        actualizados.
//        h) Obtener el número de casas que existen para cada uno de los países diferentes.
//        i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) 
//        que están ‘limpias’.
//        j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
//         */
import servicios.CasasServicio;
import servicios.ClientesServicio;
import servicios.ComentariosServicio;
import servicios.EstanciasServicio;
import servicios.familiasServicio;

import java.util.Scanner;

public class EstanciasMain {

    public static void main(String[] args) {
        CasasServicio casasS = new CasasServicio();
        ClientesServicio clienteS = new ClientesServicio();
        ComentariosServicio comentariosS = new ComentariosServicio();
        EstanciasServicio estanciasS = new EstanciasServicio();
        familiasServicio familiasS = new familiasServicio();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            String opc;
            do {
                mostrarMenu();
                opc = leer.next().toLowerCase();

                switch (opc) {     
                    case "a":
//a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima 
/// inferior a 10 años.
                      familiasS.listarFamilias(opc);
                        break;
//b) Buscar y listar las casas disponibles para el periodo comprendido 
//        entre el 1 de agosto de  2020 y el 31 de agosto de 2020 en Reino Unido.
                    case "b":
                        casasS.listarCasas(opc);
                        break;
//c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
                    case "c":
                        familiasS.listarFamilias(opc);
                        break;
//d) Casas disponibles a partir de una fecha dada y un número de días específico."
                    case "d":
                        casasS.listarCasas(opc);
                        break;
//e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la 
//descripción de la casa donde la realizaron.
                    case "e":
                        clienteS.listarClientes();
                        break;
//f) Listar todas las estancias que han sido reservadas por un cliente, 
////mostrar el nombre, país y ciudad del cliente y además la información
                    case "f":
                        estanciasS.listarEstancias();
                        break;
//g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el 
//precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios 
//actualizados.
                    case "g":
                        casasS.listarCasas(opc);
                        break;
//h) Obtener el número de casas que existen para cada uno de los países diferentes.
                    case "h":
                        casasS.listarCasas(opc);
                        break;
//i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas
//(comentarios)que están ‘limpias’.
                    case "i":
                        casasS.listarCasas(opc);
                        break;
                    case "j":
                    casasS.listarCasas(opc);
                        break;
//j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad
//de las fechas.
                    case "k":
                        System.out.println("Nos vemos...");
                        break;
                    default:
                        System.out.println("OPCIÓN INVÁLIDA. Vuelva a ingresar: ");
                        opc = leer.next().toLowerCase();
                }
            } while (!"k".equals(opc));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n a) Familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años."
                + "        \n b) Casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido."
                + "        \n c) Familias cuya dirección de correo sea de Hotmail."
                + "        \n d) Casas disponibles a partir de una fecha dada y un número de días específico."
                + "        \n e) Datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron."
                + "        \n f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó."
                + "        \n g) Incrementar el precio por día en un 5% de todas las casas del Reino Unido."
                + "        \n h) Obtener el número de casas que existen para cada uno de los países diferentes."
                + "        \n i) Casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están 'limpias'."
                + "        \n j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas."
                + "        \n k) Salir."
                + " \n Ingrese la opción deseada: ");
    }
}
