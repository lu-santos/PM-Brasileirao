/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.dao.LeitorDAO;
import modelo.dao.LeitorDeEquipe;

/**
 *
 * @author Lucianna
 */
public class EquipeEvent {
    public void importarEquipe(){
        LeitorDAO leitor = new LeitorDeEquipe();      
    }
}
