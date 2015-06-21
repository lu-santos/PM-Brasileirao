/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resultadoEsperado;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Equipe;

/**
 *
 * @author Lucianna
 */
public class EquipeEsperada {
    private List<Equipe> resultadoEsperado = new ArrayList<Equipe>();
    
    public List<Equipe> getEquipeEsperada() {
        resultadoEsperado.add(new Equipe("Cruzeiro"));
        resultadoEsperado.add(new Equipe("Criciuma"));
        resultadoEsperado.add(new Equipe("Gremio"));
        resultadoEsperado.add(new Equipe("Sao-Paulo"));
        resultadoEsperado.add(new Equipe("Coritiba"));
        resultadoEsperado.add(new Equipe("Fluminense"));
        resultadoEsperado.add(new Equipe("Vasco"));
        resultadoEsperado.add(new Equipe("Internacional"));
        resultadoEsperado.add(new Equipe("Vitoria"));
        resultadoEsperado.add(new Equipe("Botafogo"));
        resultadoEsperado.add(new Equipe("Corinthians"));
        resultadoEsperado.add(new Equipe("Flamengo"));
        resultadoEsperado.add(new Equipe("Santos"));
        resultadoEsperado.add(new Equipe("Atletico-MG"));
        resultadoEsperado.add(new Equipe("Atletico-PR"));
        resultadoEsperado.add(new Equipe("Portuguesa"));
        resultadoEsperado.add(new Equipe("Bahia"));
        resultadoEsperado.add(new Equipe("Nautico"));
        resultadoEsperado.add(new Equipe("Ponte-Preta"));
        resultadoEsperado.add(new Equipe("Goias"));
        
        return resultadoEsperado;
    }
}
