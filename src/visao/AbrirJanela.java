/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

/**
 *
 * @author Lucianna
 */
public class AbrirJanela {
    public static void abrirJanela(javax.swing.JInternalFrame proximaJanela, javax.swing.JDesktopPane janelaAtual) {
	janelaAtual.add(proximaJanela);
	proximaJanela.setVisible(true);
    }
}
