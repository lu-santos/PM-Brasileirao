/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.LeitorDeJogos;
import modelo.dao.RodadaDAO;
import modelo.entidade.Jogo;

/**
 *
 * @author Amanda
 */
public class RodadaEvent {
   
    public LeitorDeJogos leitor;
    public RodadaDAO rodadaDao;
    public List<Jogo> lista = new ArrayList<>();
    
    //metodo pra pegar evento da view
    public void pedidoDeInclusao(){
        try{
            lista = leitor.getListaDeJogos();
            //dar um jeito de iterar na lista e add cada um no bd
        }catch(Exception e){
            //escrever msg
        
        }
    }
    
}
