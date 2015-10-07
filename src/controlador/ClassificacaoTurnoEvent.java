/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.List;
import modelo.entidade.Jogo;
import modelo.entidade.Rodada;

/**
 *
 * @author Lucianna
 */
public class ClassificacaoTurnoEvent extends ClassificacaoEvent {
    private final String numeroDoTurno;
    
    public ClassificacaoTurnoEvent(String numeroDoTurno) {
        super();
        this.numeroDoTurno = numeroDoTurno;
    }
    
    @Override
    protected List<Jogo> getJogosDoCampeonato(int idCampeonato) throws Exception {
        String queryJogo = "SELECT id_rodada, id_jogo, gol_mandante, gol_visitante, nome_mandante, nome_visitante FROM tabela_jogo NATURAL INNER JOIN (SELECT * FROM tabela_rodada NATURAL INNER JOIN (SELECT id_turno FROM tabela_turno where id_campeonato =  " + idCampeonato + "  AND numero_turno = " + numeroDoTurno + ") as turno) as rodada";
        return jogoDAO.Consulta(queryJogo);
    }
    
    @Override
    protected List<Rodada> getRodadasDoCampeonato(int idCampeonato) throws Exception {
        String queryRodada = "SELECT * FROM tabela_rodada NATURAL INNER JOIN (SELECT id_turno FROM tabela_turno WHERE id_campeonato = " + idCampeonato + " AND numero_turno = " + numeroDoTurno + ") as turno";
        return rodadaDAO.Consulta(queryRodada);
    }
}
