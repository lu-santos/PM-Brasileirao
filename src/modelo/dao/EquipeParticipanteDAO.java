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
import modelo.entidade.EquipeParticipante;

/**
 *
 * @author Amanda
 */
public class EquipeParticipanteDAO extends BaseCrudDAO<EquipeParticipante>{
    private final String nomeDaTabela = "tabela_equipe_participante";
    private static ConexaoDAO conexao;
    
    public EquipeParticipanteDAO(ConexaoDAO conexao) {
        super(conexao);
    }
    
    @Override
    public String getQueryDeInclusao() {
        return "INSERT INTO " + nomeDaTabela + "(id_equipe, id_campeonato, indicador) " + "VALUES(?, ?, ?);";
    }

    @Override
    public String getQueryDeListar() {
        return "SELECT * FROM " + nomeDaTabela;
    }

    @Override
    public String getQueryDeRegistro() {
        return "SELECT * FROM " + nomeDaTabela + " WHERE id_participante = ";
    }

    @Override
    public EquipeParticipante getEntidade(ResultSet registro) {
        EquipeParticipante participante;
        try {
            participante = new EquipeParticipante();
            int id_equipe_participante = registro.getInt("id_participante");
            int id_equipe = registro.getInt("id_equipe");
            int id_campeonato = registro.getInt("id_campeonato");
            String indicador = registro.getString("indicador");
            participante.setIdParticipante(id_equipe_participante);
            participante.setIdEquipe(id_equipe);
            participante.setIdCampeonato(id_campeonato);
            participante.setIndicador(indicador);
            return participante;
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void incluirDadosNoBanco(PreparedStatement pst, EquipeParticipante entidade) {
        try {
            pst.setInt(1, entidade.getIdEquipe());
            pst.setInt(2, entidade.getIdCampeonato());
            pst.setString(3, entidade.getIndicador());
        } catch (SQLException ex) {
            Logger.getLogger(EquipeParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getQueryDeExiste(EquipeParticipante participante) {
        return "SELECT DISTINCT * FROM " + nomeDaTabela + " WHERE id_equipe = " + participante.getIdEquipe() + " AND id_campeonato = " + participante.getIdCampeonato();
    }
}
