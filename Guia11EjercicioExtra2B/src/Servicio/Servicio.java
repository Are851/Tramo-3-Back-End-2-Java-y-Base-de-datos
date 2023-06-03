package Servicio;
/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */
import Entidad.Cine;
import Entidad.Espectador;
import Entidad.Pelicula;
import java.util.Random;

public class Servicio {
    
    public void sentarEspectadores(Espectador[] espectadores, Cine cine) {
        Random random = new Random();

        for (Espectador espectador : espectadores) {
            int fila = random.nextInt(cine.getFilas());
            int columna = random.nextInt(cine.getColumnas());

            // Verificar si el asiento está ocupado
            while (cine.getSala()[fila][columna] != null) {
                fila = random.nextInt(cine.getFilas());
                columna = random.nextInt(cine.getColumnas());
            }

            // Verificar si el espectador cumple con los requisitos para ver la película
            if (espectador.getEdad() >= cine.getPelicula().getEdadMinima() && espectador.getDinero() >= cine.getPrecioEntrada()) {
                cine.getSala()[fila][columna] = espectador;
                System.out.println("El espectador " + espectador.getNombre() + " se ha sentado en la fila " + (fila + 1) + ", columna " + (columna + 1));
            } else {
                System.out.println("El espectador " + espectador.getNombre() + " no cumple los requisitos para ver la película.");
            }
        }
    }

    public void mostrarSala(Cine cine) {
        Espectador[][] sala = cine.getSala();
        int filas = cine.getFilas();
        int columnas = cine.getColumnas();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (sala[i][j] != null) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
