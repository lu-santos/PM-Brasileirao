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
public class Jogo {
    private int idJogo;
    private int idRodada;
    private int idTurno;
    private int idCampeonato;
    private int idEquipeMandante;
    private int idEquipeVisitante;
    private int golMandante;
    private int golVisitante;

    public Jogo(int idRodada, int idTurno, int idCampeonato, int idEquipeMandante, int idEquipeVisitante, int golMandante, int golVisitante) {
        this.idRodada = idRodada;
        this.idTurno = idTurno;
        this.idCampeonato = idCampeonato;
        this.idEquipeMandante = idEquipeMandante;
        this.idEquipeVisitante = idEquipeVisitante;
        this.golMandante = golMandante;
        this.golVisitante = golVisitante;
    }
    
    public Jogo(){
    }

    public int getIdJogo() {
        return idJogo;
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

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public int getIdEquipeMandante() {
        return idEquipeMandante;
    }

    public void setIdEquipeMandante(int idEquipeMandante) {
        this.idEquipeMandante = idEquipeMandante;
    }

    public int getIdEquipeVisitante() {
        return idEquipeVisitante;
    }

    public void setIdEquipeVisitante(int idEquipeVisitante) {
        this.idEquipeVisitante = idEquipeVisitante;
    }

    public int getGolMandante() {
        return golMandante;
    }

    public void setGolMandante(int golMandante) {
        this.golMandante = golMandante;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }
}