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
import modelo.entidade.Equipe;

/**
 *
 * @author Amanda
 */
public class EquipeDAO implements BaseCrudDAO<Equipe>{
    private final String nomeDaTabela = "tabela_equipe";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public EquipeDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void incluir(Equipe t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(nome, indicador) "
                + "VALUES(?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setString(1, t.getNome());
        pst.setString(2, t.getIndicador());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(Equipe t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipe visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Equipe t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Equipe> listar() throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela; 
        List<Equipe> equipes = new ArrayList<>();
        
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                Equipe equipe = new Equipe();
                equipe = registrarDados(registro, equipe);
                equipes.add(equipe);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return equipes; 
    }

    @Override
    public Equipe getRegistro(int id) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE id_equipe = " + id; 
        Equipe equipe = new Equipe();
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                registrarDados(registro, equipe);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return equipe; 
    }
    
    private Equipe registrarDados(ResultSet registro, Equipe equipe) throws SQLException {
        int id_equipe = registro.getInt("id_equipe");
        String nome = registro.getString("nome");
        String indicador = registro.getString("indicador");
        equipe.setIdEquipe(id_equipe);
        equipe.setNome(nome.trim());
        if (indicador != null)
            equipe.setIndicador(indicador.trim());
        return equipe;
    }
}
