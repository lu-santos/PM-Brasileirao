/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entidade.Equipe;

/**
 *
 * @author Amanda
 */
public class EquipeDAO extends BaseCrudDAO<Equipe>{
    private final String nomeDaTabela = "tabela_equipe";
    private static ConexaoDAO conexao;
    
    public EquipeDAO(ConexaoDAO conexao) {
        super(conexao);
    }

    @Override
    public String getQueryDeInclusao() {
        return "INSERT INTO " + nomeDaTabela + "(nome, indicador) " + "VALUES(?, ?);";
    }

    @Override
    public String getQueryDeListar() {
        return "SELECT * FROM " + nomeDaTabela;
    }

    @Override
    public String getQueryDeRegistro() {
        return "SELECT * FROM " + nomeDaTabela + " WHERE nome = ";
    }

    @Override
    public Equipe getEntidade(ResultSet registro) {
        Equipe equipe;
        try {
            equipe = new Equipe();
            int id_equipe = registro.getInt("id_equipe");
            String nome = registro.getString("nome");
            String indicador = registro.getString("indicador");
            equipe.setIdEquipe(id_equipe);
            equipe.setNome(nome.trim());
            if (indicador != null)
                equipe.setIndicador(indicador.trim());
            return equipe;
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void incluirDadosNoBanco(PreparedStatement pst, Equipe entidade) {
        try {
            pst.setString(1, entidade.getNome());
            pst.setString(2, entidade.getIndicador());
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getQueryDeExiste(Equipe equipe) {
        return "SELECT DISTINCT * FROM " + nomeDaTabela + " WHERE nome = '" + equipe.getNome() + "'";
    }
    
}
