/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;

/**
 *
 * @author Amanda
 */
public interface ConexaoDAO {
    public Connection abrirConexao() throws Exception;
    public void fecharConexao() throws Exception;   
}
