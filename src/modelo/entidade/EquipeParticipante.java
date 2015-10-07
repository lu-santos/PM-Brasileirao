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
    private String nomeEquipe;
    private int idCampeonato;
    private String Indicador;
   // private Map<String, Performance> performances = new HashMap<>();

    public EquipeParticipante(int idEquipe, int idCampeonato) {
        this.idEquipe = idEquipe;
        this.idCampeonato = idCampeonato;
    }

    public EquipeParticipante(int idEquipe, int idCampeonato, String nomeEquipe) {
        this.idEquipe = idEquipe;
        this.idCampeonato = idCampeonato;
        this.nomeEquipe = nomeEquipe;
    }
    
    public EquipeParticipante(){ 
    }
    
    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
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

    public String getIndicador() {
        return Indicador;
    }

    public void setIndicador(String Indicador) {
        this.Indicador = Indicador;
    }
/*
    public Map<String, Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Map<String, Performance> performances) {
        this.performances = performances;
    }
*/
    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

}
