/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.entidade.EquipeParticipante;

/**
 *
 * @author Amanda
 */
public class EquipeParticipanteDAO implements BaseCrudDAO<EquipeParticipante>{
    private final String nomeDaTabela = "tabela_equipe_participante";
    private String query;
    private static ConexaoDAO conexao;
    private Connection conectar;
    
    public EquipeParticipanteDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void incluir(EquipeParticipante t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id_equipe, id_campeonato) "
                + "VALUES(?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdEquipe());
        pst.setInt(2, t.getIdCampeonato());
        pst.executeUpdate();
        conexao.fecharConexao();
    }

    @Override
    public void atualizar(EquipeParticipante t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EquipeParticipante visualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(EquipeParticipante t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EquipeParticipante> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EquipeParticipante getRegistro(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
