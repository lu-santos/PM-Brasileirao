/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.dao.LeitorDAO;
import modelo.dao.LeitorDeJogos;
import modelo.dao.RodadaDAO;
import modelo.entidade.Jogo;
import modelo.entidade.Rodada;

/**
 *
 * @author Amanda
 */
public class RodadaEvent {
    private LeitorDAO leitor;
    private String nomeArquivo;
    private List<String> rodadasImportadas = new ArrayList<>();
    
    public RodadaEvent(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.leitor = new LeitorDeJogos(nomeArquivo);
        this.rodadasImportadas = new ArrayList();
    }
    
    public void adicionarRodadasImportadas(String rodada){
        if(rodadasImportadas.size() < 39)
            rodadasImportadas.add(rodada);
    }
    
    public List<String> getRodadasImportadas(){
        return rodadasImportadas;
    }

    public void ImportarRodada() {
        leitor.lerArquivo();
      
    }

  
}
