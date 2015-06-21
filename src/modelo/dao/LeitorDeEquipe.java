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
import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Equipe;

/**
 *
 * @author Lucianna
 */
public class LeitorDeEquipe implements LeitorDAO{
    private List<Equipe> listaEquipes = new ArrayList<>();
    private static final String nomeArquivo = "equipes.txt";
    
    public LeitorDeEquipe() {
        File arquivoTXT = new File(nomeArquivo);
        if (arquivoTXT.exists())
            lerArquivo();
    }
    
    @Override
    public void lerArquivo() {
        BufferedReader ler = null;
        try{
            try{
                ler = new BufferedReader(new FileReader(nomeArquivo));
                String linha = ler.readLine();
                while(ler.ready()){
                    linha = ler.readLine();
                    Equipe e = new Equipe(linha);
                    if(listaEquipes.size() <= 20)
                        listaEquipes.add(e);
                }
            }
            finally{
                if(ler != null)
                    ler.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
