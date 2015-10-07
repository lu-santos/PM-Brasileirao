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
    private int numeroRodada;
    private List<Jogo> jogosDaRodada;
    
    public Rodada(){
        
    }
    
    public Rodada(int idTurno, int numeroRodada) {
        this.idTurno = idTurno;
        this.numeroRodada = numeroRodada;
    }
    
    public Rodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;
    }

    public List<Jogo> getJogosDaRodada() {
        return jogosDaRodada;
    }

    public void setJogosDaRodada(List<Jogo> PartidasNaRodada) {
        this.jogosDaRodada = new ArrayList<>(PartidasNaRodada);
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
    
    public int getNumeroRodada() {
        return numeroRodada;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public void setNumeroRodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;
    }
}