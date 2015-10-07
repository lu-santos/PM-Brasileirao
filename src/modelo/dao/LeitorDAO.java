/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucianna
 */
public abstract class LeitorDAO<E, L> {
    
    public void lerArquivo(String nomeArquivo) {
        File arquivoTXT = new File(nomeArquivo);
        if (arquivoTXT.exists()) {
            leitura(nomeArquivo);
        }
    }
    
    private void leitura(String nomeArquivo) {
        BufferedReader ler = null;
        int i = 0;
        try{
            try{
                ler = new BufferedReader(new FileReader(nomeArquivo));
                String linha = ler.readLine();
                criarEntidade(linha);
                while(ler.ready()){
                    linha = ler.readLine();
                    criarListaDeEntidade(linha);
                }
            }
            catch (Exception ex) {
                Logger.getLogger(LeitorDeEquipe.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            } finally{
                if(ler != null)
                    ler.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    protected abstract void criarEntidade(String linha);
    protected abstract void criarListaDeEntidade(String linha);
    public abstract E getEntidade();
    public abstract List<L> getListaDeEntidade();    
}
