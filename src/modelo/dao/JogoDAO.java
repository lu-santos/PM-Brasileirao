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
import modelo.entidade.Jogo;

/**
 *
 * @author Amanda
 */
public class JogoDAO extends BaseCrudDAO<Jogo>{
    private final String nomeDaTabela = "tabela_jogo";
    private static ConexaoDAO conexao;
    
    public JogoDAO(ConexaoDAO conexao) {
        super(conexao);
    }

    @Override
    public String getQueryDeInclusao() {
        return "INSERT INTO " + nomeDaTabela + "(id_rodada, gol_mandante, gol_visitante, nome_mandante, nome_visitante) "
                + "VALUES(?, ?, ?, ?, ?);";
    }

    @Override
    public String getQueryDeListar() {
        return "SELECT * FROM " + nomeDaTabela;
    }

    @Override
    public String getQueryDeRegistro() {
        return "SELECT * FROM " + nomeDaTabela + " WHERE id_rodada = ";
    }

    @Override
    public Jogo getEntidade(ResultSet registro) {
        Jogo jogo;
        try {
            jogo = new Jogo();
            int id_jogo = registro.getInt("id_jogo");
            int id_rodada = registro.getInt("id_rodada");
            int gol_mandante = registro.getInt("gol_mandante");
            int gol_visitante = registro.getInt("gol_visitante");
            String nome_mandante = registro.getString("nome_mandante");
            String nome_visitante = registro.getString("nome_visitante");
            jogo.setIdJogo(id_jogo);
            jogo.setIdRodada(id_rodada);
            jogo.setGolMandante(gol_mandante);
            jogo.setGolVisitante(gol_visitante);
            jogo.setEquipeMandante(nome_mandante.trim());
            jogo.setEquipeVisitante(nome_visitante.trim());
            return jogo;
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void incluirDadosNoBanco(PreparedStatement pst, Jogo entidade) {
        try {
            pst.setInt(1, entidade.getIdRodada());
            pst.setInt(2, entidade.getGolMandante());
            pst.setInt(3, entidade.getGolVisitante());
            pst.setString(4, entidade.getEquipeMandante());
            pst.setString(5, entidade.getEquipeVisitante());
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getQueryDeExiste(Jogo jogo) {
        return "SELECT * FROM " + nomeDaTabela + " WHERE id_rodada = " + jogo.getIdRodada() + " AND gol_mandante = " + jogo.getGolMandante() + " AND gol_visitante = " + jogo.getGolVisitante() + " AND nome_mandante = '" + jogo.getEquipeMandante() + "' AND nome_visitante = '" + jogo.getEquipeVisitante() + "'";
    }
}
