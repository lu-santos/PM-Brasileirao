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
import modelo.entidade.Rodada;

/**
 *
 * @author Amanda
 */
public class RodadaDAO extends BaseCrudDAO<Rodada>{
    private final String nomeDaTabela = "tabela_rodada";
    private static ConexaoDAO conexao;
    
    public RodadaDAO(ConexaoDAO conexao) {
        super(conexao);
    }
 
    @Override
    public String getQueryDeInclusao() {
        return "INSERT INTO " + nomeDaTabela + "(id_turno, numero_rodada) " + "VALUES(?, ?);";
    }

    @Override
    public String getQueryDeListar() {
        return "SELECT * FROM " + nomeDaTabela;
    }

    @Override
    public String getQueryDeRegistro() {
        return "SELECT * FROM " + nomeDaTabela + " WHERE id_turno = ";
    }

    @Override
    public Rodada getEntidade(ResultSet registro) {
        Rodada entidade;
        try {
            entidade = new Rodada();
            int id_rodada = registro.getInt("id_rodada");
            int id_turno = registro.getInt("id_turno");
            int numero_rodada = registro.getInt("numero_rodada");
            entidade.setIdRodada(id_rodada);
            entidade.setIdTurno(id_turno);
            entidade.setNumeroRodada(numero_rodada);
            return entidade;
        } catch (SQLException ex) {
            Logger.getLogger(RodadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void incluirDadosNoBanco(PreparedStatement pst, Rodada entidade) {
        try {
            pst.setInt(1, entidade.getIdTurno());
            pst.setInt(2, entidade.getNumeroRodada());
        } catch (SQLException ex) {
            Logger.getLogger(RodadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getQueryDeExiste(Rodada rodada) {
        return "SELECT DISTINCT * FROM " + nomeDaTabela + " WHERE id_turno = " + rodada.getIdTurno() + " AND numero_rodada = " + rodada.getNumeroRodada();
    }
}
