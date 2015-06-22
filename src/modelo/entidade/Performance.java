/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidade;

/**
 *
 * @author Lucianna
 */
public class Performance {
    private int idEquipe;
    private int idCampeonato;
    private int idPerformance;
    private int idTurno;
    private int idRodada;
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
    private boolean visitante;
    private boolean mandante;

    public Performance(int idEquipe, int idCampeonato, int idTurno, int idRodada, int pontosGanhos, int jogos, int vitorias, int empates, int derrotas, int golsPro, int golsContra, double saldo, double aproveitamento, boolean visitante, boolean mandante) {
        this.idEquipe = idEquipe;
        this.idCampeonato = idCampeonato;
        this.idTurno = idTurno;
        this.idRodada = idRodada;
        this.pontosGanhos = pontosGanhos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldo = saldo;
        this.aproveitamento = aproveitamento;
        this.visitante = visitante;
        this.mandante = mandante;
    }
    
    public Performance(){
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public int getIdPerformance() {
        return idPerformance;
    }

    public void setIdPerformance(int idPerformance) {
        this.idPerformance = idPerformance;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(int idRodada) {
        this.idRodada = idRodada;
    }

    public int getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(int pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getAproveitamento() {
        return aproveitamento;
    }

    public void setAproveitamento(double aproveitamento) {
        this.aproveitamento = aproveitamento;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public boolean isVisitante() {
        return visitante;
    }

    public void setVisitante(boolean visitante) {
        this.visitante = visitante;
    }

    public boolean isMandante() {
        return mandante;
    }

    public void setMandante(boolean mandante) {
        this.mandante = mandante;
    }
}
