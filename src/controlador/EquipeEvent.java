/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.dao.LeitorDAO;
import modelo.dao.LeitorDeEquipe;
import modelo.dao.LeitorDeJogos;

/**
 *
 * @author Lucianna
 */
public class EquipeEvent {
    private LeitorDAO leitor;
    private String nomeArquivo;
    
    public EquipeEvent(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.leitor = new LeitorDeEquipe(nomeArquivo);
    }

    public void ImportarEquipe() {
        leitor.lerArquivo();        
    }
}
