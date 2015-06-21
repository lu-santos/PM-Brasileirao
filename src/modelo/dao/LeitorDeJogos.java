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
    public Rodada rodada;
    public Jogo jogo = new Jogo();
    public JogoDAO jogoDAO;
    List<Jogo> listaDeJogos = new ArrayList<>();
    File nomeArquivoPartidas;
    BufferedReader reader;
    
    private RodadaDAO rodadaDAO = new RodadaDAO();
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
            lerListaDeJogos();            
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void lerListaDeJogos() throws FileNotFoundException, IOException, Exception{
        try {
            reader = new BufferedReader(
                   new FileReader(nomeArquivoPartidas), 4096);
            processarLinhaArquivo(reader);
            rodada.setPartidasNaRodada(listaDeJogos);
        }finally {
            if (reader != null)
                reader.close();
        }
    }
    
    public void processarLinhaArquivo(BufferedReader reader) throws IOException, Exception{
        String linha;
        int i = 0;
        while (reader.ready()) {
            linha = reader.readLine();
            if(i == 0){
                String[] primeiraLinha = linha.split(" ");     
                incluirRodada(primeiraLinha[1]);
            }
            else{
                jogoDAO.incluir(processarLinhaJogo(linha));
            }
            i++;
        }
    }
    
     public void incluirRodada(String linha) throws Exception {
        int numeroRodada = Integer.parseInt(linha);
        rodada = new Rodada(numeroRodada);
        rodadaDAO.incluir(rodada);  
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
