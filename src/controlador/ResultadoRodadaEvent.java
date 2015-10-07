/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Campeonato;
import modelo.entidade.Rodada;
import modelo.entidade.Jogo;

/**
 *
 * @author Lucianna
 */
public class ResultadoRodadaEvent extends ClassificacaoEvent {
    private List<Jogo> jogos;
    private int idRodada;
    
    @Override
    protected List<Jogo> getJogosDoCampeonato(int idCampeonato) throws Exception {
        String queryJogo = "SELECT * FROM tabela_jogo where id_rodada = " + idRodada;
        jogos = jogoDAO.Consulta(queryJogo);
        return jogos;
    }
    
    public List<String> getNumeroRodada(Integer anoDoCampeonato) throws Exception {
        int idCampeonato = campeonatoDAO.getRegistro(anoDoCampeonato).getIdCampeonato();
        List<String> numeroRodada = new ArrayList();
        String query = "SELECT * FROM tabela_rodada NATURAL INNER JOIN (SELECT id_turno FROM tabela_turno WHERE id_campeonato = " + idCampeonato + ") as turno";
        for (Rodada r : rodadaDAO.Consulta(query)) {
            numeroRodada.add(String.valueOf(r.getNumeroRodada()));
        }
        return numeroRodada;
    }
    
    public List<Jogo> getListaDeJogos(Integer anoDoCampeonato, int numeroRodada) throws Exception {
        String query = "SELECT * FROM tabela_rodada WHERE numero_rodada = " + numeroRodada;
        idRodada = rodadaDAO.Consulta(query).get(0).getIdRodada();
        limparListas();
        campeonato = new Campeonato(anoDoCampeonato);
        this.anoDoCampeonato = anoDoCampeonato;
        int idCampeonato = campeonatoDAO.getRegistro(anoDoCampeonato).getIdCampeonato();
        organizarDados();
        return getJogosDoCampeonato(idCampeonato);
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
