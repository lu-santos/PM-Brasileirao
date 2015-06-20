/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;

/**
 *
 * @author Amanda
 * @param <T>
 */
public interface BaseCrudDAO<T> extends ConexaoDAO {
    public void incluir(T t) throws Exception;
    public void atualizar(T t) throws Exception;
    public T visualizar() throws Exception;
    public void excluir(T t) throws Exception;
    public List<T> listar() throws Exception;
}
