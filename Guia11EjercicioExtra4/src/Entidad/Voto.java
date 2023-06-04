/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 */


public class Voto {
    private Alumno alumno;
    private List<Alumno> votos;

    public Voto(Alumno alumno) {
        this.alumno = alumno;
        this.votos = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public List<Alumno> getVotos() {
        return votos;
    }

    public void agregarVoto(Alumno alumnoVotado) {
        if (!votos.contains(alumnoVotado) && alumnoVotado != alumno) {
            votos.add(alumnoVotado);
            alumnoVotado.incrementarVoto();
        }
    }
}


