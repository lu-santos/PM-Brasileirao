/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Campeonato;
import modelo.entidade.Equipe;

/**
 *
 * @author Lucianna
 */
public class LeitorDeEquipe extends LeitorDAO<Campeonato, Equipe>{
    private final String nomeArquivo;
    private int anoCampeonato;
    private Campeonato campeonato;
    private final List<Equipe> equipes;
    
    public LeitorDeEquipe(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.equipes = new ArrayList<>();
        lerArquivo(nomeArquivo);
    }
    
    @Override
    protected void criarEntidade(String linha) {
        anoCampeonato = Integer.parseInt(linha);
        campeonato = new Campeonato(anoCampeonato);
    }
    
    @Override
    protected void criarListaDeEntidade(String linha) {
        Equipe equipe;
        if (linha.indexOf(" ") != -1) {
            String[] partes = linha.split(" ");
            equipe = new Equipe(partes[0]);
            equipe.setIndicador(partes[1]);
        }
        else {
            equipe = new Equipe(linha);
        }
        equipes.add(equipe);
    }
            
    @Override
    public Campeonato getEntidade() {
        return campeonato;
    }
    
    @Override
    public List<Equipe> getListaDeEntidade() {
        return equipes;
    }
}