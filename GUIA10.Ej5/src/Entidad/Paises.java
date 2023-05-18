/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se 
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los 
países guardados en el conjunto. (Recordemos hacer los servicios en la clase 
correspondiente) Después deberemos mostrar el conjunto ordenado alfabéticamente:
para esto recordar cómo se ordena un conjunto. Por último, al usuario se le 
pedirá un país y se recorrerá el conjunto con un Iterator, se buscará el país 
en el conjunto y si está en el conjunto se eliminará el país que ingresó el 
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se 
le informará al usuario. 
 */
package Entidad;


/**
 *
 * @author Rob
 */
public class Paises
{
    private String nombrepaises;

    public Paises() {
    }

    public Paises(String nombrepaises) {
        this.nombrepaises = nombrepaises;
    }

    public String getNombrepaises() {
        return nombrepaises;
    }

    public void setNombrepaises(String nombrepaises) {
        this.nombrepaises = nombrepaises;
    }

    @Override
    public String toString() {
        return "Paises{" + "nombrepaises=" + nombrepaises + '}';
    }
    
}
