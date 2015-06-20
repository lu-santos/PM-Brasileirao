/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.sql.Connection;

/**
 *
 * @author Lucianna
 */
public interface Conexao {
    public Connection abrirConexao() throws Exception;
    public void fecharConexao() throws Exception;   
}
