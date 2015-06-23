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
import modelo.entidade.Turno;

/**
 *
 * @author Amanda
 */
public class TurnoDAO implements BaseCrudDAO<Turno>{
    private final String nomeDaTabela = "tabela_turno";
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
        pst.setInt(1, t.getIdCampeonato());
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
        PreparedStatement stmt = null;
        ResultSet registro = null;
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela; 
        List<Turno> turnos = new ArrayList<>();
        
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                Turno turno = new Turno();
                turno = registrarDados(registro, turno);
                turnos.add(turno);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return turnos;
    }

    @Override
    public Turno getRegistro(int numeroTurno) throws Exception {
        PreparedStatement stmt = null;
        ResultSet registro = null;
        
        conectar = conexao.abrirConexao();
        query = "SELECT * FROM " + nomeDaTabela + " WHERE numero_turno = " + numeroTurno; 
        Turno turno = new Turno();
        try{
            stmt = conectar.prepareStatement(query);
            registro = stmt.executeQuery();
            while(registro.next()){
                registrarDados(registro, turno);
            }
        }catch(SQLException e){
            System.out.println("Erro na listagem " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return turno; 
    }
    
    private Turno registrarDados(ResultSet registro, Turno turno) throws SQLException {
        int id_turno = registro.getInt("id_turno");
        int id_campeonato = registro.getInt("id_campeonato");
        int numero_turno = registro.getInt("numero_turno");
        turno.setIdTurno(id_turno);
        turno.setIdCampeonato(id_campeonato);
        turno.setNumeroTurno(numero_turno);
        return turno;
    }
    
}
