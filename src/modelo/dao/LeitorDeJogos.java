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
import modelo.entidade.Campeonato;
import modelo.entidade.Turno;

/**
 *
 * @author Amanda
 */
public class LeitorDeJogos implements LeitorDAO{
    private Rodada rodada;
    private Turno turno;
    private Campeonato campeonato;
    private Jogo jogo;
    private JogoDAO jogoDAO;
    private TurnoDAO turnoDAO;
    private EquipeDAO equipeDAO;
    private CampeonatoDAO campeonatoDAO;
    private List<Jogo> listaDeJogos = new ArrayList<>();
    private File nomeArquivoPartidas;
    private BufferedReader reader;
    private int numeroTurno, anoCampeonato, idTurno, idRodada, idEquipeMandante, idEquipeVisitante, idCampeonato;
    
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
        linha = reader.readLine();
        
        String[] primeiraLinha = linha.split(" ");     
        incluirRodada(primeiraLinha[1]);
        
        while (reader.ready()) {
            linha = reader.readLine();
            jogoDAO.incluir(processarLinhaJogo(linha));
        }
    }
    
     public void incluirRodada(String linha) throws Exception {
        int numeroRodada = Integer.parseInt(linha);
        idCampeonato = getIdCampeonato();
        
        if (numeroRodada == 1) {
            numeroTurno = 1;
            gerarRodadaEmTurnoNovo(numeroRodada);
        }
        else if (numeroRodada < 20) {
            numeroTurno = 1;
            gerarRodada(numeroRodada);
        }
        
        if (numeroRodada == 20 ) {
            numeroTurno = 2;
            gerarRodadaEmTurnoNovo(numeroRodada);
        }
        else if (numeroRodada > 20) {
            numeroTurno = 2;
            gerarRodada(numeroRodada);
        }
        rodadaDAO.incluir(rodada);  
    }

    private void gerarRodada(int numeroRodada) throws Exception {
        idTurno = getIdTurno();
        rodada = new Rodada(idTurno, idCampeonato, numeroRodada);
    }

    private void gerarRodadaEmTurnoNovo(int numeroRodada) throws Exception {
        inserirTurno();
        gerarRodada(numeroRodada);
    }

    private int getIdTurno() throws Exception {
        turno = turnoDAO.getRegistro(numeroTurno);
        return turno.getIdTurno();
    }

    private void inserirTurno() throws Exception {
        turno = new Turno(idCampeonato, numeroTurno);
        turnoDAO.incluir(turno);
    }

    private int getIdCampeonato() throws Exception {
        int ultimoCampeonato = campeonatoDAO.listar().size();
        campeonato = campeonatoDAO.listar().get(ultimoCampeonato);
        return campeonato.getIdCampeonato();
    }
     
    public Jogo processarLinhaJogo(String linha) throws Exception{
        String[] partes = linha.split(" ");
        String nomeMandante = partes[0];      
        String gols = partes[1];              
        String nomeVisitante = partes[2];     
                    
        String[] valores = partes[1].split("x"); 
        int golMandante = Integer.parseInt(valores[0]);
        int golVisitante = Integer.parseInt(valores[1]);
        
        idRodada = rodadaDAO.getRegistro(numeroTurno).getIdRodada();
        jogo = new Jogo(idRodada, idTurno, idCampeonato, golMandante, golVisitante, nomeMandante, nomeVisitante);
        return jogo;
    }
}
