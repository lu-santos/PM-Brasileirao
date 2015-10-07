/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidade;

import java.util.ArrayList;
import java.util.List;
import visao.ColunaTabela;

/**
 *
 * @author Lucianna
 */
public class Performance {
    private String nomeParticipante;
    private int posicao;
    private int pontosGanhos;
    private int jogos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsPro;
    private int golsContra;
    private double saldo;
    private double aproveitamento;
    private String indicador;
    private List<Jogo> listaDeJogos;
    
    public int compareTo(Performance p){
        if(this.getPontosGanhos() < p.getPontosGanhos())
            return 1;
        if(this.getPontosGanhos() > p.getPontosGanhos())
            return -1;
        if(this.getPontosGanhos() == p.getPontosGanhos()){
            if(this.getSaldo() < p.getSaldo())
                return 1;
            if(this.getSaldo() > p.getSaldo())
                return -1;
            if(this.getSaldo() == p.getSaldo())
                return 0;
        }
        return 0;    
    }

    public Performance(String nomeParticipante, List<Jogo> listaDeJogos) {
        this.nomeParticipante = nomeParticipante;
        this.listaDeJogos = new ArrayList<>(listaDeJogos);
        calcularValores();
    }
    
    public Performance(){
    }
    
    @ColunaTabela(nome="Equipe", indice=2)
    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setnomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }
    
    @ColunaTabela(nome="PG", indice=3)
    public int getPontosGanhos() {
        pontosGanhos = ((vitorias*3) + (empates*1));
        return pontosGanhos;
    }

    public void setPontosGanhos(int pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    @ColunaTabela(nome="Jogos", indice=4)
    public int getJogos() {
        jogos = listaDeJogos.size();
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }
    
    private void calcularValores() {
        vitorias = 0;
        derrotas = 0;
        empates = 0;
        golsPro = 0;
        golsContra = 0;
        for (int i = 0; i < listaDeJogos.size(); i++){
            if(listaDeJogos.get(i).getGolMandante() == listaDeJogos.get(i).getGolVisitante())
                empates += 1;
            if (getNomeParticipante().equalsIgnoreCase(listaDeJogos.get(i).getEquipeMandante())) {
                if (listaDeJogos.get(i).getGolMandante() > listaDeJogos.get(i).getGolVisitante()) {
                    vitorias += 1;
                }
                else if (listaDeJogos.get(i).getGolMandante() < listaDeJogos.get(i).getGolVisitante()) {
                    derrotas += 1;
                }
                golsPro += listaDeJogos.get(i).getGolMandante();
                golsContra += listaDeJogos.get(i).getGolVisitante();
            }
            else if (getNomeParticipante().equalsIgnoreCase(listaDeJogos.get(i).getEquipeVisitante())) {
                if (listaDeJogos.get(i).getGolVisitante() > listaDeJogos.get(i).getGolMandante()) {
                    vitorias += 1;
                }
                else if (listaDeJogos.get(i).getGolVisitante() < listaDeJogos.get(i).getGolMandante()) {
                    derrotas += 1;
                }
                golsPro += listaDeJogos.get(i).getGolVisitante();
                golsContra += listaDeJogos.get(i).getGolMandante();
            }
        }
    }

    @ColunaTabela(nome="Vitorias", indice=5)
    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    @ColunaTabela(nome="Empates", indice=6)
    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    @ColunaTabela(nome="Derrotas", indice=7)
    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    @ColunaTabela(nome="Gol Pro", indice=8)
    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    @ColunaTabela(nome="Gol Contra", indice=9)
    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    @ColunaTabela(nome="Saldo", indice=10)
    public double getSaldo() {
        saldo = (golsPro - golsContra);
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @ColunaTabela(nome="%", indice=11, formato="%.2f")
    public double getAproveitamento() {
        aproveitamento = ((double)pontosGanhos/(double)(jogos*3))*100;
        return aproveitamento;
    }

    public void setAproveitamento(double aproveitamento) {
        this.aproveitamento = aproveitamento;
    }

    @ColunaTabela(nome="Indicador", indice=1)
    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    @ColunaTabela(nome="Posição", indice=0)
    public int getPosicao() {
        return posicao;
    }
    
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }    
}
