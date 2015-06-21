/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.entidade.Performance;

/**
 *
 * @author Amanda
 */
public class PerformanceDAO implements BaseCrudDAO<Performance>{
    private final String nomeDaTabela = "tabela_performance";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public PerformanceDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void incluir(Performance t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id_rodada, id_turno, id_campeonato, id_equipe, id_participante, pontos_ganhos, vitorias, derrotas, empates, jogos, gols_pro, gols_contra, indicador, saldo, aproveitamente, visitante, mandante) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdRodada());
        pst.setInt(2, t.getIdTurno());
        pst.setInt(3, t.getIdCampeonato());
        pst.setInt(4, t.getIdEquipe());
        pst.setInt(5, t.getIdParticipante());
        pst.setInt(6, t.getPontosGanhos());
        pst.setInt(7, t.getVitorias());
        pst.setInt(8, t.getDerrotas());
        pst.setInt(9, t.getEmpates());
        pst.setInt(10, t.getJogos());
        pst.setInt(11, t.getGolsPro());
        pst.setInt(12, t.getGolsContra());
        pst.setString(13, t.getIndicador());
        pst.setDouble(14, t.getSaldo());
        pst.setDouble(15, t.getAproveitamento());
        pst.setBoolean(16, t.isMandante());
        pst.setBoolean(17, t.isVisitante());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(Performance t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Performance visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Performance t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Performance> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
