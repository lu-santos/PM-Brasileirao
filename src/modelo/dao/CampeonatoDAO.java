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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campeonato getRegistro(int id) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        Connection conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE id_campeonato = " + id; 
        Campeonato campeonato = new Campeonato();
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                int id_campeonato = registro.getInt("id_campeonato");
                int ano = registro.getInt("ano");
                campeonato.setAno(ano);
                campeonato.setIdCampeonato(id_campeonato);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return campeonato; 
    }
}
