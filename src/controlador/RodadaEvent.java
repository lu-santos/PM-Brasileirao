/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.CampeonatoDAO;
import modelo.dao.ConexaoDAO;
import modelo.dao.ConexaoPostgre;
import modelo.dao.JogoDAO;
import modelo.dao.LeitorDAO;
import modelo.dao.LeitorDeJogos;
import modelo.dao.RodadaDAO;
import modelo.dao.TurnoDAO;
import modelo.entidade.Jogo;
import modelo.entidade.Turno;
import modelo.entidade.Rodada;
import modelo.entidade.Campeonato;

/**
 *
 * @author Amanda
 */
public class RodadaEvent {
    private LeitorDAO leitor;
    private String nomeArquivo;
    private final ConexaoDAO conexao;
    private CampeonatoDAO campeonatoDAO;
    private TurnoDAO turnoDAO;
    private final RodadaDAO rodadaDAO;
    private JogoDAO jogoDAO;
    private Rodada rodada;
    private Turno turno;
    private final int turno1 = 1, turno2 = 2;
    private int idTurnoDaRodada;
    private Integer anoCampeonato;
    private int idCampeonato;
    
    public RodadaEvent(String nomeArquivo, Integer anoCampeonato) {
        this.nomeArquivo = nomeArquivo;
        this.anoCampeonato = anoCampeonato;
        this.leitor = new LeitorDeJogos(nomeArquivo);
        this.conexao = new ConexaoPostgre();
        this.campeonatoDAO = new CampeonatoDAO(conexao);
        this.turnoDAO = new TurnoDAO(conexao);
        this.rodadaDAO = new RodadaDAO(conexao);
        this.jogoDAO = new JogoDAO(conexao);
    }
    
    public RodadaEvent(){
        this.conexao = new ConexaoPostgre();
        this.rodadaDAO = new RodadaDAO(conexao);
    }

    public void ImportarRodada() throws Exception {
        tipoDeTurno();
        tipoDeRodada();
        incluirJogo();
    }

    private void tipoDeTurno() throws Exception {
        rodada = (Rodada) leitor.getEntidade();
        Campeonato campeonato = campeonatoDAO.getRegistro(anoCampeonato);
        
        if (campeonato != null) {
            if (rodada.getNumeroRodada() < 20) {
                incluirTurno(turno1, campeonato);
            }
            else if (rodada.getNumeroRodada() >= 20) {
                incluirTurno(turno2, campeonato);
            }
        }
    }
    
    private void incluirTurno(int numeroDoTurno, Campeonato campeonato) throws Exception {
        idCampeonato = campeonato.getIdCampeonato();
        turno = new Turno(idCampeonato, numeroDoTurno);
        turnoDAO.incluir(turno);
    }
    
    private void tipoDeRodada() throws Exception {
        String queryTurno1 = "SELECT * from tabela_turno WHERE id_campeonato = " + idCampeonato + " AND numero_turno = " + turno1;
        int idTurno1 = turnoDAO.Consulta(queryTurno1).get(0).getIdTurno();
        
        if (rodada.getNumeroRodada() < 20) {
            incluirRodada(idTurno1);
            idTurnoDaRodada = idTurno1;
        }
        else if (rodada.getNumeroRodada() >= 20) {
            String queryTurno2 = "SELECT * from tabela_turno WHERE id_campeonato = " + idCampeonato + " AND numero_turno = " + turno2;
            int idTurno2 = turnoDAO.Consulta(queryTurno2).get(0).getIdTurno();
            incluirRodada(idTurno2);
            idTurnoDaRodada = idTurno2;
        }
    }
    
    private void incluirRodada(int idTurno) throws Exception {
        rodada.setIdTurno(idTurno);
        rodadaDAO.incluir(rodada);
    }
    
    private void incluirJogo() throws Exception {
        List<Jogo> jogos = leitor.getListaDeEntidade();
        String query = "SELECT * FROM tabela_rodada WHERE numero_rodada = " + rodada.getNumeroRodada();
        int idRodada = rodadaDAO.Consulta(query).get(0).getIdRodada();
        for (Jogo jogo : jogos) {
            jogo.setIdRodada(idRodada);
            jogoDAO.incluir(jogo);
        }
    }
    
    public List getRodadasNoBanco() throws Exception {
        List numeroDasRodadas = new ArrayList();
        for(Rodada r : rodadaDAO.listar()) {
            numeroDasRodadas.add(r.getNumeroRodada());
        }
        return numeroDasRodadas;
    }
}