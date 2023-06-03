/*
Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene 
un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas,
bastos, oros y copas). 
Esta clase debe contener un método toString() que retorne el número de carta y
el palo. La baraja estarácompuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando
no haya más o se haya llegado al final, se indica al usuario que no hay más 
cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese 
número decartas. En caso de que haya menos cartas que las pedidas, no
devolveremos nada, pero debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido 
ninguna indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se 
saca una carta y luego se llama al método, este no mostrara esa primera carta.
 */
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */

import java.util.ArrayList;

public class Baraja {
    private ArrayList <Carta> cartas = new ArrayList();
    private String[] palos = {"Espada","Basto","Oro","Copa"};
    private ArrayList <Carta> monton = new ArrayList();

    public Baraja() {
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public String[] getPalos() {
        return palos;
    }

    public ArrayList<Carta> getMonton() {
        return monton;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setPalos(String[] palos) {
        this.palos = palos;
    }

    public void setMonton(ArrayList<Carta> monton) {
        this.monton = monton;
    }

    @Override
    public String toString() {
        return "Baraja{" + "cartas=" + cartas + ", palos=" + palos + '}';
    }
}
  