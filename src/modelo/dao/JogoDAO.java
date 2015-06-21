/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.entidade.Jogo;

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
        query = "INSERT INTO " + nomeDaTabela + "(id_rodada, id_turno, id_campeonato, id_equipe_mandante, id_equipe_visitante, gol_mandante, gol_visitante) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdRodada());
        pst.setInt(2, t.getIdTurno());
        pst.setInt(3, t.getIdCampeonato());
        pst.setInt(4, t.getIdEquipeMandante());
        pst.setInt(5, t.getIdEquipeVisitante());
        pst.setInt(6, t.getGolMandante());
        pst.setInt(7, t.getGolVisitante());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
