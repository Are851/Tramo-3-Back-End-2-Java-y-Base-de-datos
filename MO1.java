/*
Toma la Lista, el Conjunto y el Mapa del ejemplo y agrega 5 objetos a cada uno.
 */
package Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import Entidad.Libro;

public class MO1 {

  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);

    int edad[] = new int[5];
    String nombre[] = {"sad", "dad", "dad", "asdasd", "adsd"};

    //LIBRO EJEMPRO
    ArrayList<Libro> libros = new ArrayList();

    //carga libro
    for (int i = 0; i < edad.length; i++) {
      Libro li = new Libro();
      
      System.out.println("Libro: " + i);
      li.setLibro(read.next());
      
      libros.add(li);
    }

    //muestra arrays objetos
    libros.forEach((ejemplar) -> {
      System.out.println(ejemplar);
    });
            
    //carga edad
    for (int i = 0; i < edad.length; i++) {
      edad[i] = (int) (Math.random() * 100);
    }

    
    
    //LISTAS
    ArrayList<Integer> numA = new ArrayList();

    for (int i = 0; i < edad.length; i++) {
      numA.add(edad[i]);

    }

    System.out.println("ListaA : " + numA);

    
    
    //CONJUNTOS
    HashSet<Integer> numB = new HashSet();

    for (int j = 0; j < edad.length; j++) {
      numB.add(edad[j]);
    }

    System.out.println("ListaB : " + numB);

    
    
    //MAPAS
    HashMap<Integer, String> alumnos = new HashMap();

    for (int k = 0; k < edad.length; k++) {
      alumnos.put(edad[k], nombre[k]);
    }

    System.out.println("ListaC : " + alumnos);
  }

}
