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
public class Campeonato {
    
    private int idCampeonato;
    private int ano;
    
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
    
    public void setAno(int ano) {
        this.ano = ano;
    }
}
