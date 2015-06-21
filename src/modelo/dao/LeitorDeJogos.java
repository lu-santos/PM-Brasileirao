/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Jogo;
import modelo.entidade.Rodada;

/**
 *
 * @author Amanda
 */
public class LeitorDeJogos implements LeitorDAO{
    public Rodada rodada =  new Rodada();
    public Jogo jogo = new Jogo();
    List<Jogo> listaDeJogos = new ArrayList<>();
    File nomeArquivoPartidas;
    BufferedReader reader;
    
    private RodadaDAO equipeDAO = new RodadaDAO();
    String nomeArquivo;

     public LeitorDeJogos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
   
    @Override
    public void lerArquivo() {
        File arquivoTXT = new File(nomeArquivo);
        if (arquivoTXT.exists())
            leitura();
    }
    
    private void leitura() {
        try{
            getListaDeJogos();            
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public List getListaDeJogos() throws FileNotFoundException, IOException{
        try {
            reader = new BufferedReader(
                   new FileReader(nomeArquivoPartidas), 4096);
            processarLinhaArquivo(reader);
            rodada.setPartidasNaRodada(listaDeJogos);
        }finally {
            if (reader != null)
                reader.close();
        }
        return listaDeJogos;
    }
    
    public void processarLinhaArquivo(BufferedReader reader) throws IOException{
        String linha;
        int i = 0;
        while (reader.ready()) {
            linha = reader.readLine();
            if(i == 0){
                String[] primeiraLinha = linha.split(" ");     
                rodada.setNumeroRodada(Integer.parseInt(primeiraLinha[1]));
            }
            else{
                listaDeJogos.add(processarLinhaJogo(linha));
            }
            i++;
        }
    }
    
    
    public Jogo processarLinhaJogo(String linha){
        String[] partesSemX = linha.split(" x ");
        String lado1 = partesSemX[0];
        String lado2 = partesSemX[1];
        String[] resultadoMandante = lado1.split(" ");
        String[] resultadoVisitante = lado2.split(" ");

        jogo.setEquipeMandante(resultadoMandante[0]);
        jogo.setGolMandante(Integer.parseInt(resultadoMandante[1]));

        jogo.setGolVisitante(Integer.parseInt(resultadoVisitante[0]));
        jogo.setEquipeVisitante(resultadoVisitante[1]);

        return jogo;
    
    }
}
