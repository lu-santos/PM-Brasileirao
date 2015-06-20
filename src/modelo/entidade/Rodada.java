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
public class Rodada {
    
    private int idRodada;
    private int idTurno;
    private int idCampeonato;
    private int numeroRodada;
    
    public Rodada(int idTurno, int idCampeonato, int numeroRodada) {
        this.idTurno = idTurno;
        this.idCampeonato = idCampeonato;
        this.numeroRodada = numeroRodada;
    }
    
    public Rodada(){
        
    }
    
    public int getIdRodada() {
        return idRodada;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }
    
    public int getNumeroRodada() {
        return numeroRodada;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }
        
    public void setNumeroRodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;
    }
}