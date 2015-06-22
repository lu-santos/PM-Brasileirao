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
    private int numeroTurno, anoCampeonato, idTurno, idRodada, idEquipeMandante, idEquipeVisitante, idCampeonato;
    
    private ConexaoDAO conexao = new ConexaoPostgre();
    private RodadaDAO rodadaDAO;
    String nomeArquivo;

     public LeitorDeJogos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.jogoDAO = new JogoDAO(conexao);
        this.turnoDAO = new TurnoDAO(conexao);
        this.equipeDAO = new EquipeDAO(conexao);
        this.campeonatoDAO = new CampeonatoDAO(conexao);
        this.rodadaDAO = new RodadaDAO(conexao);
    }
   
    @Override
    public void lerArquivo() {
        File arquivoTXT = new File(nomeArquivo);
        if (arquivoTXT.exists())
            leitura();
    }
    
    private void leitura() {
        System.out.println("teste9");
        BufferedReader ler = null;
        try{
            try {
                ler = new BufferedReader(new FileReader(nomeArquivo));
                String linha = ler.readLine();
                String[] primeiraLinha = linha.split(" ");     
                incluirRodada(primeiraLinha[1]);
                System.out.println(nomeArquivo);
                while (ler.ready()) {
                    linha = ler.readLine();
                    System.out.println("10");
                    jogoDAO.incluir(processarLinhaJogo(linha));
                }
                rodada.setPartidasNaRodada(listaDeJogos);
            }finally {
                if (ler != null)
                    ler.close();
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
        
     public void incluirRodada(String linha) throws Exception {
        int numeroRodada = Integer.parseInt(linha);
        System.out.println("teste5");
        getIdCampeonato();
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
        System.out.println("tabela turno " + idCampeonato);
        turno = new Turno(idCampeonato, numeroTurno);
        turnoDAO.incluir(turno);
    }

    private void getIdCampeonato() throws Exception {
        int ultimoCampeonato = campeonatoDAO.listar().size()-1;
        campeonato = campeonatoDAO.listar().get(ultimoCampeonato);
        System.out.println(campeonato.getIdCampeonato());
        idCampeonato = campeonato.getIdCampeonato();
    }
     
    public Jogo processarLinhaJogo(String linha) throws Exception{
        String[] partes = linha.split(" ");
        String nomeMandante = partes[0];      
        String gols = partes[1];              
        String nomeVisitante = partes[2];     
                    
        String[] valores = partes[1].split("x"); 
        int golMandante = Integer.parseInt(valores[0]);
        int golVisitante = Integer.parseInt(valores[1]);
        System.out.println("teste11");
        idRodada = rodadaDAO.getRegistro(numeroTurno).getIdRodada();
        jogo = new Jogo(idRodada, idTurno, idCampeonato, golMandante, golVisitante, nomeMandante, nomeVisitante);
        return jogo;
    }
}
