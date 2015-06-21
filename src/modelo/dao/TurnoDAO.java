/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.entidade.Turno;

/**
 *
 * @author Amanda
 */
public class TurnoDAO implements BaseCrudDAO<Turno>{
    private final String nomeDaTabela = "tabela_rodada";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public TurnoDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void incluir(Turno t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id_campeonato, numero_turno) "
                + "VALUES(?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdTurno());
        pst.setInt(2, t.getNumeroTurno());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(Turno t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Turno t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turno> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno getRegistro(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
