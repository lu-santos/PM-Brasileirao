/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.entidade.Rodada;

/**
 *
 * @author Amanda
 */
public class RodadaDAO implements BaseCrudDAO<Rodada>{

    private final String nomeDaTabela = "tabela_rodada";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public RodadaDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }


    RodadaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void incluir(Rodada t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id_turno, id_campeonato, numero_rodada) "
                + "VALUES(?, ?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdRodada());
        pst.setInt(2, t.getIdTurno());
        pst.setInt(3, t.getNumeroRodada());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(Rodada t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rodada visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Rodada t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rodada> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rodada getRegistro(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
