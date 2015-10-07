/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.List;
import modelo.dao.CampeonatoDAO;
import modelo.dao.ConexaoDAO;
import modelo.dao.ConexaoPostgre;
import modelo.dao.EquipeDAO;
import modelo.dao.EquipeParticipanteDAO;
import modelo.dao.LeitorDAO;
import modelo.dao.LeitorDeEquipe;
import modelo.entidade.Campeonato;
import modelo.entidade.Equipe;
import modelo.entidade.EquipeParticipante;

/**
 *
 * @author Lucianna
 */
public class EquipeEvent {
    private final LeitorDAO leitor;
    private final String nomeArquivo;
    private final ConexaoDAO conexao;
    private final CampeonatoDAO campeonatoDAO;
    private final EquipeDAO equipeDAO;
    private final EquipeParticipanteDAO participanteDAO;
    private Integer anoCampeonato;
    
    public EquipeEvent(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.leitor = new LeitorDeEquipe(nomeArquivo);
        this.conexao = new ConexaoPostgre();
        this.campeonatoDAO = new CampeonatoDAO(conexao);
        this.equipeDAO = new EquipeDAO(conexao);
        this.participanteDAO = new EquipeParticipanteDAO(conexao);
    }

    public void ImportarEquipe() throws Exception {
        incluirCampeonato();
        incluirEquipe();
    }

    private void incluirEquipe() throws Exception {
        List<Equipe> equipes = leitor.getListaDeEntidade();
        for (Equipe equipe : equipes) {
            equipeDAO.incluir(equipe);
            incluirEquipeParticipante(equipe);
        }
    }

    private void incluirEquipeParticipante(Equipe e) throws Exception {
        int idEquipe = equipeDAO.getRegistro(e.getNome()).getIdEquipe();
        int idCampeonato = campeonatoDAO.getRegistro(anoCampeonato).getIdCampeonato();
        EquipeParticipante participante = new EquipeParticipante(idEquipe, idCampeonato);
        if (e.getIndicador() != null) {
            participante.setIndicador(e.getIndicador());
        }
        participanteDAO.incluir(participante);
    }

    private void incluirCampeonato() throws Exception {
        Campeonato campeonato = (Campeonato) leitor.getEntidade();
        anoCampeonato = campeonato.getAno();
        campeonatoDAO.incluir(campeonato);
    }
    
}
