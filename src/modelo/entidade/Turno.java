/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidade;

/**
 *
 * @author Lucianna
 */
public class Turno {
    
    private int idTurno;
    private int idCampeonato;
    private int numeroTurno;

    public Turno(int idCampeonato, int numeroTurno) {
        this.idCampeonato = idCampeonato;
        this.numeroTurno = numeroTurno;
    }
    
    public Turno(){
    }
    
    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }
    
    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }
}
