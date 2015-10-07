/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modelo.dao.CampeonatoDAO;
import modelo.dao.ConexaoDAO;
import modelo.dao.ConexaoPostgre;
import modelo.dao.EquipeDAO;
import modelo.dao.EquipeParticipanteDAO;
import modelo.dao.JogoDAO;
import modelo.dao.RodadaDAO;
import modelo.dao.TurnoDAO;
import modelo.entidade.Campeonato;
import modelo.entidade.Equipe;
import modelo.entidade.Jogo;
import modelo.entidade.Performance;
import modelo.entidade.Rodada;
import modelo.entidade.Turno;

/**
 *
 * @author Lucianna
 */
public abstract class ClassificacaoEvent {
    protected Integer anoDoCampeonato;
    private final ConexaoDAO conexao;
    protected List<Performance> performances;
    protected final CampeonatoDAO campeonatoDAO;
    protected final JogoDAO jogoDAO;
    private final TurnoDAO turnoDAO;
    protected final RodadaDAO rodadaDAO;
    protected final EquipeDAO equipeDAO;
    private final EquipeParticipanteDAO participanteDAO;
    
    protected Campeonato campeonato;
    protected List<Turno> turnos;
    protected List<Rodada> rodadas;
    protected List<Jogo> jogos;
    protected List<Equipe> equipes;
    
    public ClassificacaoEvent() {
        this.performances = new ArrayList<>();
        this.conexao = new ConexaoPostgre();
        this.campeonatoDAO = new CampeonatoDAO(conexao);
        this.turnoDAO = new TurnoDAO(conexao);
        this.rodadaDAO = new RodadaDAO(conexao);
        this.jogoDAO = new JogoDAO(conexao);
        this.equipeDAO = new EquipeDAO(conexao);
        this.participanteDAO = new EquipeParticipanteDAO(conexao);
    }
        
    public List<Campeonato> getListaDeCampeonato() throws Exception {
        List<Campeonato> lista = campeonatoDAO.listar();
        return lista;
    } 
    
    public int getNumeroDaUltimaRodada() {
        List<Integer> listaDeNumero = new ArrayList();
        for (Rodada r : rodadas) {
            listaDeNumero.add(r.getNumeroRodada());
        }
        return Collections.max(listaDeNumero);
    }
    
    public List<Performance> getListaDePerformance(Integer anoDoCampeonato) throws Exception {
        limparListas();
        campeonato = new Campeonato(anoDoCampeonato);
        this.anoDoCampeonato = anoDoCampeonato;
        organizarDados();
        return calcularPerformanceCampeonato();
    }
       
    protected void limparListas() {
        if (turnos != null) {
            turnos.clear();
            rodadas.clear();
            jogos.clear();
            equipes.clear();
            performances.clear();
        }
    }
    
    protected List<Performance> calcularPerformanceCampeonato() throws Exception {
        equipes = equipeDAO.listar();
        List<Jogo> jogosDaEquipe = new ArrayList<>();
        Performance p;
        for(int i = 0; i < equipes.size(); i++) {
            for(Jogo j : jogos) {
                if (equipes.get(i).getNome().equalsIgnoreCase(j.getEquipeMandante()) || equipes.get(i).getNome().equalsIgnoreCase(j.getEquipeVisitante())) {
                   jogosDaEquipe.add(j);
                }
            }
            if(!jogosDaEquipe.isEmpty()) {
                p = new Performance(equipes.get(i).getNome(), jogosDaEquipe);
                performances.add(p);
                jogosDaEquipe.clear();
            }
        }
        addIndicadorDaEquipe(performances);
        return performances;
    }
    
    protected void addIndicadorDaEquipe(List<Performance> p) {
        Comparator<Performance> ordemDecrescentePG = new Comparator<Performance>(){
            @Override
            public int compare(Performance p1, Performance p2){
                return p1.compareTo(p2);
            }
        };
        Collections.sort(p, ordemDecrescentePG);
        int j = 1;
        for(int i = 0; i < p.size() ; i++){
            if (i < 4)
                p.get(i).setIndicador("Libertadores");
            if (i > 15)
                p.get(i).setIndicador("Rebaixado");
            p.get(i).setPosicao(j++);
        }
    }
    
    protected void organizarDados() throws Exception {
        int idCampeonato = campeonatoDAO.getRegistro(anoDoCampeonato).getIdCampeonato();
        turnos = getTurnosDoCampeonato(idCampeonato);
        rodadas = getRodadasDoCampeonato(idCampeonato);
        jogos = getJogosDoCampeonato(idCampeonato);
        addJogosNaRodada();
        addRodadasNoTurno();
        addTurnosNoCampeonato(idCampeonato);
    }

    protected List<Jogo> getJogosDoCampeonato(int idCampeonato) throws Exception {
        String queryJogo = "SELECT id_rodada, id_jogo, gol_mandante, gol_visitante, nome_mandante, nome_visitante FROM tabela_jogo NATURAL INNER JOIN (SELECT * FROM tabela_rodada NATURAL INNER JOIN (SELECT id_turno FROM tabela_turno where id_campeonato = " + idCampeonato + ") as turno) as rodada";
        return jogoDAO.Consulta(queryJogo);
    }

    protected List<Rodada> getRodadasDoCampeonato(int idCampeonato) throws Exception {
        String queryRodada = "SELECT * FROM tabela_rodada NATURAL INNER JOIN (SELECT id_turno FROM tabela_turno WHERE id_campeonato = " + idCampeonato + ") as turno";
        return rodadaDAO.Consulta(queryRodada);
    }

    private List<Turno> getTurnosDoCampeonato(int idCampeonato) throws Exception {
        String queryTurno = "SELECT * FROM tabela_turno WHERE id_campeonato = " + idCampeonato;
        return turnoDAO.Consulta(queryTurno);
    }

    private void addTurnosNoCampeonato(int idCampeonato) {
        campeonato.setIdCampeonato(idCampeonato);
        campeonato.setTurnos(turnos);
    }
    
    private void addJogosNaRodada() {
        List<Jogo> jogosDaRodada = new ArrayList<>();
        for (int i = 0; i < rodadas.size(); i++) {
            for (Jogo j : jogos) {
                if (rodadas.get(i).getIdRodada() == j.getIdRodada())
                    jogosDaRodada.add(j);
            }
            rodadas.get(i).setJogosDaRodada(jogosDaRodada);
            jogosDaRodada.clear();
        }
    }
    
    private void addRodadasNoTurno() {
        List<Rodada> rodadasDoTurno = new ArrayList<>();
        for (int i = 0; i < turnos.size(); i++) {
            for (Rodada r : rodadas) {
                if (turnos.get(i).getIdTurno() == r.getIdTurno())
                    rodadasDoTurno.add(r);
            }
            turnos.get(i).setRodadasDoTurno(rodadasDoTurno);
            rodadasDoTurno.clear();
        }
    }
}
