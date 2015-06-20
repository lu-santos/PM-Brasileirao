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
public class EquipeParticipante {
    private int idParticipante;
    private int idEquipe;
    private int idCampeonato;

    public EquipeParticipante(int idEquipe, int idCampeonato) {
        this.idEquipe = idEquipe;
        this.idCampeonato = idCampeonato;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    
}
