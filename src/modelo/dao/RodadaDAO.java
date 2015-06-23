/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 
    @Override
    public void incluir(Rodada t) throws Exception {
        query = "INSERT INTO " + nomeDaTabela + "(id_turno, id_campeonato, numero_rodada) "
                + "VALUES(?, ?, ?);";
        conectar = conexao.abrirConexao();
        PreparedStatement pst = conectar.prepareStatement(query);
        pst.setInt(1, t.getIdTurno());
        pst.setInt(2, t.getIdCampeonato());
        pst.setInt(3, t.getNumeroRodada());
        pst.executeUpdate();
        System.out.print("teste20");
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
        PreparedStatement stmt = null;
        ResultSet registro = null;
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela; 
        List<Rodada> rodadas = new ArrayList<>();
        
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                Rodada rodada = new Rodada();
                rodada = registrarDados(registro, rodada);
                rodadas.add(rodada);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return rodadas; 
    }

    @Override
    public Rodada getRegistro(int numero_rodada) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE numero_rodada = " + numero_rodada; 
        Rodada rodada = new Rodada();
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                registrarDados(registro, rodada);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return rodada; 
    }
    
    private Rodada registrarDados(ResultSet registro, Rodada rodada) throws SQLException {
        int id_rodada = registro.getInt("id_rodada");
        int id_turno = registro.getInt("id_turno");
        int id_campeonato = registro.getInt("id_campeonato");
        int numero_rodada = registro.getInt("numero_rodada");
        rodada.setIdRodada(id_rodada);
        rodada.setIdTurno(id_turno);
        rodada.setIdCampeonato(id_campeonato);
        rodada.setNumeroRodada(numero_rodada);
        return rodada;
    }
}
