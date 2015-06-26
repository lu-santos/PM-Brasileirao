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
import modelo.entidade.Campeonato;

/**
 *
 * @author Amanda
 */
public class CampeonatoDAO implements BaseCrudDAO<Campeonato>{
    private final String nomeDaTabela = "tabela_campeonato";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public CampeonatoDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }

    @Override
    public void incluir(Campeonato t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(ano) "
                + "VALUES(?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getAno());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(Campeonato t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campeonato visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Campeonato t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Campeonato> listar() throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela; 
        List<Campeonato> campeonatos = new ArrayList<>();
        
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                Campeonato campeonato = null;
                campeonato = registrarDados(registro, campeonato);
                campeonatos.add(campeonato);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem de campeonato: " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return campeonatos; 
    }

    @Override
    public Campeonato getRegistro(int ano) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE ano = " + ano; 
        Campeonato campeonato = null;
        
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                campeonato = registrarDados(registro, campeonato);
            }
        }catch(SQLException e){
            System.out.println("Erro ao pesquisar registro: " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return campeonato; 
    }
    
    private Campeonato registrarDados(ResultSet registro, Campeonato campeonato) throws SQLException {
        campeonato = new Campeonato();
        int id_campeonato = registro.getInt("id_campeonato");
        int ano = registro.getInt("ano");
        campeonato.setAno(ano);
        campeonato.setIdCampeonato(id_campeonato);
        return campeonato;
    }
}
