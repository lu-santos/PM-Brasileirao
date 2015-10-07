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
import modelo.entidade.Campeonato;

/**
 *
 * @author Amanda
 */
public class CampeonatoDAO extends BaseCrudDAO<Campeonato>{
    private final String nomeDaTabela = "tabela_campeonato";
    private static ConexaoDAO conexao;
  
    public CampeonatoDAO(ConexaoDAO conexao) {
        super(conexao);
    }

    @Override
    public String getQueryDeInclusao() {
        return "INSERT INTO " + nomeDaTabela + "(ano) " + "VALUES(?);";
    }

    @Override
    public String getQueryDeListar() {
        return "SELECT * FROM " + nomeDaTabela;
    }

    @Override
    public String getQueryDeRegistro() {
        return "SELECT * FROM " + nomeDaTabela + " WHERE ano = ";
    }

    @Override
    public Campeonato getEntidade(ResultSet registro) {
        Campeonato campeonato;
        try {
            campeonato = new Campeonato();
            int id_campeonato = registro.getInt("id_campeonato");
            int ano = registro.getInt("ano");
            campeonato.setAno(ano);
            campeonato.setIdCampeonato(id_campeonato);
            return campeonato;
        } catch (SQLException ex) {
            Logger.getLogger(CampeonatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void incluirDadosNoBanco(PreparedStatement pst, Campeonato entidade) {
        try {
            pst.setInt(1, entidade.getAno());
        } catch (SQLException ex) {
            Logger.getLogger(CampeonatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getQueryDeExiste(Campeonato campeonato) {
        return "SELECT DISTINCT * FROM " + nomeDaTabela + " WHERE ano = " + campeonato.getAno();
    }
}
