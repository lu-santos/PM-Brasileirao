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
import modelo.entidade.Turno;

/**
 *
 * @author Amanda
 */
public class TurnoDAO extends BaseCrudDAO<Turno>{
    private final String nomeDaTabela = "tabela_turno";
    private static ConexaoDAO conexao;
    
    public TurnoDAO(ConexaoDAO conexao) {
        super(conexao);
    }

    @Override
    public String getQueryDeInclusao() {
        return "INSERT INTO " + nomeDaTabela + "(id_campeonato, numero_turno) " + "VALUES(?, ?);";
    }

    @Override
    public String getQueryDeListar() {
        return "SELECT * FROM " + nomeDaTabela;
    }

    @Override
    public String getQueryDeRegistro() {
        return "SELECT * FROM " + nomeDaTabela + " WHERE id_campeonato = ";
    }

    @Override
    public Turno getEntidade(ResultSet registro) {
        Turno turno;
        try {
            turno = new Turno();
            int id_turno = registro.getInt("id_turno");
            int id_campeonato = registro.getInt("id_campeonato");
            int numero_turno = registro.getInt("numero_turno");
            turno.setIdTurno(id_turno);
            turno.setIdCampeonato(id_campeonato);
            turno.setNumeroTurno(numero_turno);
            return turno;
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void incluirDadosNoBanco(PreparedStatement pst, Turno entidade) {
        try {
            pst.setInt(1, entidade.getIdCampeonato());
            pst.setInt(2, entidade.getNumeroTurno());
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getQueryDeExiste(Turno turno) {
        return "SELECT DISTINCT * FROM " + nomeDaTabela + " WHERE id_campeonato = " + turno.getIdCampeonato() + " AND numero_turno = " + turno.getNumeroTurno();
    }
}
