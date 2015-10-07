/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Jogo;
import modelo.entidade.Performance;

/**
 *
 * @author Lucianna
 */
public class ClassificacaoVisitanteEvent extends ClassificacaoEvent {
    @Override
    protected List<Performance> calcularPerformanceCampeonato() throws Exception {
        equipes = equipeDAO.listar();
        List<Jogo> jogosDaEquipe = new ArrayList<>();
        Performance p;
        for(int i = 0; i < equipes.size(); i++) {
            for(Jogo j : jogos) {
                if (equipes.get(i).getNome().equalsIgnoreCase(j.getEquipeVisitante())) {
                   jogosDaEquipe.add(j);
                }
            }
            if(!jogosDaEquipe.isEmpty()) {
                p = new Performance(equipes.get(i).getNome(), jogosDaEquipe);
                performances.add(p);
                jogosDaEquipe.clear();
            }
        }
        addIndicadorDaEquipe(performances);
        return performances;
    }
}
