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
public class Equipe {
    private int idEquipe;
    private String nome;
    private String indicador;

    public Equipe(String nome) {
        this.nome = nome;
    }

    public Equipe(String nome, String indicador) {
        this.nome = nome;
        this.indicador = indicador;
    }

    public Equipe(){
    }
    
    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
        
}
