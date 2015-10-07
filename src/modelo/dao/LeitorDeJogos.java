/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Jogo;
import modelo.entidade.Rodada;

/**
 *
 * @author Amanda
 */
public class LeitorDeJogos extends LeitorDAO<Rodada, Jogo>{
    private Jogo jogo;
    private int numeroRodada;
    private final String nomeArquivo;
    private Rodada rodada;
    private final List<Jogo> jogos;

     public LeitorDeJogos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.jogos = new ArrayList<>();
        lerArquivo(nomeArquivo);
    }
   
    @Override
    protected void criarEntidade(String linha) {
        String[] primeiraLinha = linha.split(" ");
        numeroRodada = Integer.parseInt(primeiraLinha[1]);
        rodada = new Rodada(numeroRodada);
    } 

    @Override
    protected void criarListaDeEntidade(String linha) {
        String[] partes = linha.split(" ");
        String nomeMandante = partes[0];      
        String gols = partes[1];              
        String nomeVisitante = partes[2];     
        String[] valores = partes[1].split("x"); 
        int golMandante = Integer.parseInt(valores[0]);
        int golVisitante = Integer.parseInt(valores[1]);
        jogo = new Jogo(golMandante, golVisitante, nomeMandante, nomeVisitante);
        jogos.add(jogo);
    }

    @Override
    public Rodada getEntidade() {
        return rodada;
    }

    @Override
    public List<Jogo> getListaDeEntidade() {
        return jogos;
    }
}
