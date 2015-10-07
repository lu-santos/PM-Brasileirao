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

/**
 *
 * @author Lucianna
 * @param <T>
 */
public abstract class BaseCrudDAO<T> {
    private String query;
    private Connection conectar;
    private final ConexaoDAO conexao;
    
    public BaseCrudDAO(ConexaoDAO conexao) {
        this.conexao = conexao;
    }
    
    public void incluir(T entidade) throws Exception {
        if (existe(entidade) == false) {
            conectar = conexao.abrirConexao();
            query = getQueryDeInclusao();
            PreparedStatement pst = conectar.prepareStatement(query);
            incluirDadosNoBanco(pst, entidade);
            pst.executeUpdate();
            conexao.fecharConexao();
        }
    }
    
    public List<T> listar() throws Exception {
        conectar = conexao.abrirConexao();
        query = getQueryDeListar(); 
        List<T> listaDeEntidade = new ArrayList<>();
        try{
            PreparedStatement pst = conectar.prepareStatement(query);
            ResultSet registro = pst.executeQuery();
            while(registro.next()){
                T entidade;
                entidade = getEntidade(registro);
                listaDeEntidade.add(entidade);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar: " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return listaDeEntidade; 
    }
    
    public T getRegistro(Object valor) throws Exception {
        conectar = conexao.abrirConexao();
        query = getQueryDeRegistro() + "'" + valor + "'"; 
        T entidade = null;
        try{
            PreparedStatement pst = conectar.prepareStatement(query);
            ResultSet registro = pst.executeQuery();
            while(registro.next()){
                entidade = getEntidade(registro);
            }
        }catch(SQLException e){
            System.out.println("Erro ao pesquisar registro: " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return entidade; 
    }
    
    public List<T> Consulta(String consulta) throws Exception {
        conectar = conexao.abrirConexao();
        query = consulta; 
        List<T> listaDeEntidade = new ArrayList<>();
        try{
            PreparedStatement pst = conectar.prepareStatement(query);
            ResultSet registro = pst.executeQuery();
            while(registro.next()){
                T entidade = getEntidade(registro);
                listaDeEntidade.add(entidade);
            }
        }catch(SQLException e){
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }
        return listaDeEntidade; 
    }
    
    public boolean existe(T entidade) throws Exception {
        conectar = conexao.abrirConexao();
        query = getQueryDeExiste(entidade);
        T entidadeDoBanco = null;
        try{
            PreparedStatement pst = conectar.prepareStatement(query);
            ResultSet registro = pst.executeQuery();
            while(registro.next()){
                entidadeDoBanco = getEntidade(registro);
            }
            return entidadeDoBanco != null;
        }catch(SQLException e){
            System.out.println("Erro ao verificar se existe a tupla no banco: " + e.getMessage());
        }finally{
            conexao.fecharConexao();
        }        
        return false;
    }
    
    public abstract String getQueryDeExiste(T entidade);
    public abstract String getQueryDeInclusao();
    public abstract String getQueryDeListar();
    public abstract String getQueryDeRegistro();
    public abstract T getEntidade(ResultSet registro);
    public abstract void incluirDadosNoBanco(PreparedStatement pst, T entidade);
    
}
