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
public class Campeonato {
    
    private int idCampeonato;
    private int ano;
    private List<Turno> turnos;
    private List<Equipe> equipes;
    
    public Campeonato(int ano) {
        this.ano = ano;
    }
    
    public Campeonato(){
    }
        
    public int getAno() {
        return ano;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = new ArrayList<>(turnos);
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = new ArrayList<>(equipes);
    }
    
}
