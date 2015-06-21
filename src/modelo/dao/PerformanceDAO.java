/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        query = "INSERT INTO " + nomeDaTabela + "(id_rodada, id_turno, id_campeonato, id_equipe, pontos_ganhos, vitorias, derrotas, empates, jogos, gols_pro, gols_contra, indicador, saldo, aproveitamente, visitante, mandante) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, );";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdRodada());
        pst.setInt(2, t.getIdTurno());
        pst.setInt(3, t.getIdCampeonato());
        pst.setInt(4, t.getIdEquipe());
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
        PreparedStatement stmt = null;
        ResultSet registro = null;
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela; 
        List<Performance> performances = new ArrayList<>();
        
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                Performance performance = registrarDados(registro);
                performances.add(registrarDados(registro));
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return performances; 
    }

    @Override
    public Performance getRegistro(int id) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE id_performance = " + id; 
        Performance performance = null;
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                performance = registrarDados(registro);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return performance; 
    }
    
    private Performance registrarDados(ResultSet registro) throws SQLException {
        Performance performance;
        int id_performance = registro.getInt("id_performance");
        int id_rodada = registro.getInt("id_rodada");
        int id_turno = registro.getInt("id_turno");
        int id_campeonato = registro.getInt("id_campeonato");
        int id_equipe = registro.getInt("id_equipe");
        int pontos_ganhos = registro.getInt("pontos_ganhos");
        int vitorias = registro.getInt("vitorias");
        int derrotas = registro.getInt("derrotas");
        int empates = registro.getInt("empates");
        int jogos = registro.getInt("jogos");
        int gols_pro = registro.getInt("gols_pro");
        int gols_contra = registro.getInt("gols_contra");
        String indicador = registro.getString("indicador");
        double saldo = registro.getDouble("saldo");
        double aproveitamento = registro.getDouble("aproveitamento");
        boolean visitante = registro.getBoolean("visitante");
        boolean mandante = registro.getBoolean("mandante");
        
        performance = new Performance(id_equipe, id_campeonato, id_turno, id_rodada, pontos_ganhos, 
                jogos, vitorias, empates, derrotas, gols_pro, gols_contra, saldo, aproveitamento, visitante, mandante);
        
        performance.setIdPerformance(id_performance);
        return performance;
    }
}
