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
import modelo.entidade.Jogo;
import modelo.entidade.Equipe;

/**
 *
 * @author Amanda
 */
public class JogoDAO implements BaseCrudDAO<Jogo>{
    private final String nomeDaTabela = "tabela_jogo";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public JogoDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void incluir(Jogo t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id_rodada, id_turno, id_campeonato, id_equipe_mandante, id_equipe_visitante, gol_mandante, gol_visitante, nome_mandante, nome_visitante) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdRodada());
        pst.setInt(2, t.getIdTurno());
        pst.setInt(3, t.getIdCampeonato());
        pst.setInt(4, t.getIdEquipeMandante());
        pst.setInt(5, t.getIdEquipeVisitante());
        pst.setInt(6, t.getGolMandante());
        pst.setInt(7, t.getGolVisitante());
        pst.setString(8, t.getEquipeMandante());
        pst.setString(9, t.getEquipeVisitante());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(Jogo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jogo visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Jogo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jogo> listar() throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela; 
        List<Jogo> jogos = new ArrayList<>();
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                Jogo jogo = new Jogo();
                jogo = registrarDados(registro, jogo);
                jogos.add(jogo);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return jogos;
    }

    @Override
    public Jogo getRegistro(int id) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE id_jogo = " + id; ; 
        Jogo jogo = new Jogo();
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                registrarDados(registro, jogo);     
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return jogo;
    }
    
    private Jogo registrarDados(ResultSet registro, Jogo jogo) throws SQLException {
         int id_jogo = registro.getInt("id_jogo");
         int id_rodada = registro.getInt("id_rodada");
         int id_turno = registro.getInt("id_turno");
         int id_campeonato = registro.getInt("id_campeonato");
         int id_equipe_mandante = registro.getInt("id_equipe_mandante");
         int id_equipe_visitante = registro.getInt("id_equipe_visitante");
         int gol_mandante = registro.getInt("gol_mandante");
         int gol_visitante = registro.getInt("gol_visitante");
         String nome_mandante = registro.getString("nome_mandante");
         String nome_visitante = registro.getString("nome_visitante");
         jogo.setIdJogo(id_jogo);
         jogo.setIdRodada(id_rodada);
         jogo.setIdTurno(id_turno);
         jogo.setIdCampeonato(id_campeonato);
         jogo.setIdEquipeMandante(id_equipe_mandante);
         jogo.setIdEquipeVisitante(id_equipe_visitante);
         jogo.setGolMandante(gol_mandante);
         jogo.setGolVisitante(gol_visitante);
         jogo.setEquipeMandante(nome_mandante.trim());
         jogo.setEquipeVisitante(nome_visitante.trim()); 
         return jogo;
    }

}
