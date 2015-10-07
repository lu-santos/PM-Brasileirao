/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import controlador.RodadaEvent;
import modelo.entidade.Rodada;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import resultadoEsperado.RodadaEsperada;

/**
 *
 * @author Lucianna
 */
public class RodadaTeste {
    private RodadaEvent rodadaEvento;
    private String caminhoDoArquivo = "arquivos_de_leitura\\rodada1.txt";
    private ConexaoDAO conexaoDAO = new ConexaoPostgre();
    private RodadaDAO rodadaDAO = new RodadaDAO(conexaoDAO); 
    private RodadaEsperada resultadoEsperado = new RodadaEsperada();
    private List<Rodada> rodadas;
    private int numeroRodada = 1;
    
    @Test
    public void teste() throws Exception {
        rodadas = rodadaDAO.listar();
        testarImportarRodada();
        testarListarRodada();
        testarGetRegistro();
    }
    
    public void testarImportarRodada() {
  //      rodadaEvento = new RodadaEvent(caminhoDoArquivo);
    //    rodadaEvento.ImportarRodada();
    }
    
    public void testarListarRodada() throws Exception {
        for(int i = 0; i < rodadas.size(); i++) {
            assertEquals(rodadas.get(i).getNumeroRodada(), resultadoEsperado.getRodadaEsperada()[i]);
        }
    }
    public void testarGetRegistro() throws Exception {
        assertEquals(rodadaDAO.getRegistro(numeroRodada).getNumeroRodada(), resultadoEsperado.getRodadaEsperada()[0]);
    }
}
