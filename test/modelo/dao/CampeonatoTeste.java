/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import org.junit.Test;

/**
 *
 * @author Lucianna
 */
public class CampeonatoTeste {
    private ConexaoDAO conexaoDAO = new ConexaoPostgre();
    private CampeonatoDAO campeonatoDAO = new CampeonatoDAO(conexaoDAO); 
    
    @Test
    public void testSetNome()
    {
   
    }
}
