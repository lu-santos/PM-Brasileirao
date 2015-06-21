/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import controlador.EquipeEvent;
import resultadoEsperado.EquipeEsperada;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Lucianna
 */
public class EquipeTeste {
    private EquipeEvent equipeEvento;
    private String nomeArquivo = "equipes.txt";
    private String caminhoDoArquivo = "arquivos_de_leitura\\equipes.txt";
    private ConexaoDAO conexaoDAO = new ConexaoPostgre();
    private EquipeDAO equipeDAO = new EquipeDAO(conexaoDAO); 
    private EquipeEsperada resultadoEsperado = new EquipeEsperada();
    
    @Test
    public void teste() throws Exception {
        testarImportarEquipe();
        testarListarEquipe();
        testarGetRegistro();
    }
    
    public void testarImportarEquipe() {
        equipeEvento = new EquipeEvent(caminhoDoArquivo);
        equipeEvento.ImportarEquipe();
    }
    
    public void testarListarEquipe() throws Exception {
        for(int i = 0; i < 20; i++) {
            assertEquals(equipeDAO.listar().get(i).getNome(), resultadoEsperado.getEquipeEsperada().get(i).getNome());
        }
    }
    public void testarGetRegistro() throws Exception {
        assertEquals(equipeDAO.getRegistro(65).getNome(), resultadoEsperado.getEquipeEsperada().get(1).getNome());
    }
}
