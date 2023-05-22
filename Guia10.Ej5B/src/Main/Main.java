/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author RobAre
 */
public class Main {

public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PaisServicio ps = new PaisServicio();
        HashSet<String> paises = ps.cargarPaises(leer);
        System.out.println("Ordenar y mostrar");
        System.out.println("------------------------");
        ps.ordernarYmostrar(paises);
        System.out.println("Eliminar pais");
        System.out.println("------------------------");
        ps.eliminarPais(paises, leer);
        System.out.println("Mostrar");
        System.out.println("------------------------");
        ps.ordernarYmostrar(paises);
    }
    
}
