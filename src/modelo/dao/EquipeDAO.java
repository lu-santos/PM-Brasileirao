/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.entidade.Equipe;

/**
 *
 * @author Amanda
 */
public class EquipeDAO implements BaseCrudDAO<Equipe>{
    private final String nomeDaTabela = "tabela_equipe";
    String query;
    private static ConexaoDAO conexao = new ConexaoPostgre();
    private Connection conectar;
    
    @Override
    public void incluir(Equipe t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id, nome, indicador) "
                + "VALUES(?, ?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, 1);
        pst.setString(2, t.getNome());
        pst.setString(3, t.getIndicador());
        pst.executeQuery();
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
