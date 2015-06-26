/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import controlador.EquipeEvent;
import modelo.entidade.Equipe;
import java.util.List;
import resultadoEsperado.EquipeEsperada;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Lucianna
 */
public class EquipeTeste {
    private EquipeEvent equipeEvento;
    private String caminhoDoArquivo = "arquivos_de_leitura\\equipes.txt";
    private ConexaoDAO conexaoDAO = new ConexaoPostgre();
    private EquipeDAO equipeDAO = new EquipeDAO(conexaoDAO); 
    private EquipeEsperada resultadoEsperado = new EquipeEsperada();
    private List<Equipe> equipes;
    private int idEquipe = 446;
    
    @Test
    public void teste() throws Exception {
        equipes = equipeDAO.listar();
        testarImportarEquipe();
        testarListarEquipe();
        testarGetRegistro();
    }
    
    public void testarImportarEquipe() {
        equipeEvento = new EquipeEvent(caminhoDoArquivo);
        equipeEvento.ImportarEquipe();
    }
    
    public void testarListarEquipe() throws Exception {
        assertEquals(equipes.size(), 20);
        for(int i = 0; i < 20; i++) {
            assertEquals(equipes.get(i).getNome(), resultadoEsperado.getEquipeEsperada()[i]);
        }
    }
    public void testarGetRegistro() throws Exception {
        assertEquals(equipeDAO.getRegistro(idEquipe).getNome(), resultadoEsperado.getEquipeEsperada()[0]);
    }
}
