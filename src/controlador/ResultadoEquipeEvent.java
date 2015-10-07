/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Campeonato;
import modelo.entidade.Equipe;
import modelo.entidade.Jogo;

/**
 *
 * @author Lucianna
 */
public class ResultadoEquipeEvent extends ClassificacaoEvent {
    private String nomeEquipe;
    private List<Jogo> jogos;
    
    @Override
    protected List<Jogo> getJogosDoCampeonato(int idCampeonato) throws Exception {
        String queryJogo = "SELECT id_rodada, id_jogo, gol_mandante, gol_visitante, nome_mandante, nome_visitante FROM tabela_jogo NATURAL INNER JOIN (SELECT * FROM tabela_rodada NATURAL INNER JOIN (SELECT id_turno FROM tabela_turno where id_campeonato = " + idCampeonato + ") as turno) as rodada where nome_mandante = '" + nomeEquipe + "' or nome_visitante = '" + nomeEquipe + "'";
        jogos = jogoDAO.Consulta(queryJogo);
        return jogos;
    }
    public void setEquipe(String equipe) {
        nomeEquipe = equipe;
    }

    public List<String> getEquipeParticipante(Integer anoDoCampeonato) throws Exception {
        int idCampeonato = campeonatoDAO.getRegistro(anoDoCampeonato).getIdCampeonato();
        List<String> nomeDeEquipes = new ArrayList();
        String query = "select e.id_equipe, e.nome, e.indicador from tabela_equipe as e cross join tabela_equipe_participante as p where e.id_equipe = p.id_equipe and p.id_campeonato = " + idCampeonato;
        for (Equipe e : equipeDAO.Consulta(query)) {
            nomeDeEquipes.add(e.getNome());
        }
        return nomeDeEquipes;
    }
    
    public List<Jogo> getListaDeJogos(Integer anoDoCampeonato, String tipo) throws Exception {
        limparListas();
        campeonato = new Campeonato(anoDoCampeonato);
        this.anoDoCampeonato = anoDoCampeonato;
        int idCampeonato = campeonatoDAO.getRegistro(anoDoCampeonato).getIdCampeonato();
        System.out.println("teste");
        organizarDados();
        return getTipoDeJogo(tipo, idCampeonato);
    }

    private List<Jogo> getTipoDeJogo(String tipo, int idCampeonato) throws Exception {
        List<Jogo> jogosTipo = new ArrayList<>();
        getJogosDoCampeonato(idCampeonato);
        for(Jogo j : jogos) {
            if (nomeEquipe.equalsIgnoreCase(j.getEquipeMandante()) && tipo.equalsIgnoreCase("Mandante")) {
                jogosTipo.add(j);
            }
            if (nomeEquipe.equalsIgnoreCase(j.getEquipeVisitante()) && tipo.equalsIgnoreCase("Visitante")) {
                jogosTipo.add(j);
            }
        }
        return jogosTipo;
    }
    
    @Override
    protected void limparListas() {
        if (turnos != null) {
            turnos.clear();
            rodadas.clear();
            jogos.clear();
        }
    }
}
