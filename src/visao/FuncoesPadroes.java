/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import controlador.ClassificacaoEvent;
import controlador.ResultadoEquipeEvent;
import controlador.ResultadoRodadaEvent;
import java.awt.Component;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.entidade.Campeonato;

/**
 *
 * @author Lucianna
 */
public class FuncoesPadroes {
    public static void abrirJanela(javax.swing.JInternalFrame proximaJanela, javax.swing.JDesktopPane janelaAtual) {
	janelaAtual.add(proximaJanela);
	proximaJanela.setVisible(true);
    }
    
    public static void exibirMensagem(Component componentePai, String mensagem) {
        JOptionPane.showMessageDialog(componentePai, mensagem); 
    }
    
    public static void addListModelCampeonato(ClassificacaoEvent classificacao, JComboBox selecionarCampeonato) throws Exception {
        List<Campeonato> campeonatos = classificacao.getListaDeCampeonato();
        for (Campeonato campeonato : campeonatos) {
            selecionarCampeonato.addItem(String.valueOf(campeonato.getAno()));
        }
        selecionarCampeonato.setSelectedIndex(0);
    }
    public static void addListModelEquipe(ResultadoEquipeEvent classificacao, JComboBox selecionarEquipe, Integer ano) throws Exception {
        List<String> equipes = classificacao.getEquipeParticipante(ano);
        for (int i = 0; i < equipes.size(); i++) {
            selecionarEquipe.addItem(equipes.get(i));
        }
        selecionarEquipe.setSelectedIndex(0);
    }
    public static void addListModelRodada(ResultadoRodadaEvent classificacao, JComboBox selecionarRodada, Integer ano) throws Exception {
        selecionarRodada.removeAllItems();
        List<String> rodadas = classificacao.getNumeroRodada(ano);
        for (int i = 0; i < rodadas.size(); i++) {
            selecionarRodada.addItem(rodadas.get(i));
        }
        if (!rodadas.isEmpty())
            selecionarRodada.setSelectedIndex(0);
    }
}
