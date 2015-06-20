/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucianna
 */
public class ConexaoPostgre {
    private static final String bdURL = "jdbc:db2://localhost:50000/PCS_SGBD";
    private final String usuario = "postgre";
    private final String senha = "1234";
    private final String bdSqlDriver = "org.postgresql.Driver";
    private Connection conexao;
    
    protected Connection abrirConexao() throws Exception{
        try{
           Class.forName(bdSqlDriver);
        }catch(ClassNotFoundException e){
            System.out.println("Classe nao encontrada");
            throw e;
        }try{
            conexao = DriverManager.getConnection(bdURL, usuario, senha);
        }catch(SQLException e){
            System.out.println("Erro na conexao");
            throw e;
        }
        return conexao;
    }
    
    protected void fecharConexao() throws SQLException{
        try{
            conexao.close();
        }catch(SQLException e){
            throw e;
        }    
    }
}