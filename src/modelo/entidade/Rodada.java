/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucianna
 */
public class Rodada {
    
    private int idRodada;
    private int idTurno;
    private int idCampeonato;
    private int numeroRodada;
    private List<Jogo> PartidasNaRodada = new ArrayList<>();
    
    public Rodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;
    }
    
    public Rodada(){
        
    }

    public List<Jogo> getPartidasNaRodada() {
        return PartidasNaRodada;
    }

    public void setPartidasNaRodada(List<Jogo> PartidasNaRodada) {
        this.PartidasNaRodada = PartidasNaRodada;
    }
    
    public int getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(int idRodada) {
        this.idRodada = idRodada;
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