/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import modelo.dao.LeitorDAO;
import modelo.dao.LeitorDeJogos;
import modelo.dao.RodadaDAO;
import modelo.entidade.Jogo;
import modelo.entidade.Rodada;

/**
 *
 * @author Amanda
 */
public class RodadaEvent{
    private LeitorDAO leitor;
    
    public RodadaEvent(LeitorDAO leitor) {
        this.leitor = leitor;
    }

    public void ImportarRodada() {
        leitor.lerArquivo();        
    }
}
