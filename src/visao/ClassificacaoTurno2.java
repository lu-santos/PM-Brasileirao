/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import modelo.entidade.Campeonato;
import modelo.entidade.Performance;
//import Servicos.ServicoClassificacaoEquipe;
//import Servicos.ServicoImportacaoResultado;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucianna
 */
public class ClassificacaoTurno2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClassificacaoTurno2
     */
    
    private DefaultTableModel modelo;
//    private ServicoImportacaoResultado servicos;
 //   private ServicoClassificacaoEquipe classificacaoTurno2;
    private Campeonato c;
   
    public ClassificacaoTurno2() {
        initComponents();
        
 /*       servicos = new ServicoImportacaoResultado();
        servicos.lerArquivoXMLExistente("campeonato2013.xml");
        c = servicos.getCampeonato();
        selecionarCampeonato.addItem(c.getAno());
  */      
        String[] cabecalho = {"Posição", "Indicador", "Equipe", "PG", "J", "V", "E", "D", "GP", "GC", "S", "Aproveitamento"};
        String[][] dados = {};
        modelo = new DefaultTableModel(dados, cabecalho);
        tabelaClassificacaoTurno2.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        selecionarCampeonato = new javax.swing.JComboBox();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClassificacaoTurno2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        labelNumeroRodada = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Classificação do 2º Turno");
        setMinimumSize(new java.awt.Dimension(1020, 510));
        setPreferredSize(new java.awt.Dimension(1020, 510));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Campeonato");

        selecionarCampeonato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnOk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        tabelaClassificacaoTurno2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaClassificacaoTurno2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaClassificacaoTurno2);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Rodada");

        labelNumeroRodada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelNumeroRodada.setText("______");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selecionarCampeonato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNumeroRodada)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionarCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk)
                    .addComponent(labelNumeroRodada))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
   /*     servicos.lerArquivoXMLExistente("campeonato2013.xml");
        c = servicos.getCampeonato();
        classificacaoTurno2 = new ServicoClassificacaoEquipe(c);
        List<Performace> p = classificacaoTurno2.obterClassificacaoTurno(1);
        
        if(p.isEmpty() == false){
            Comparator<Performace> ordemDecrescentePG = new Comparator<Performace>(){
                public int compare(Performace p1, Performace p2){
                    return p1.compareTo(p2);
                }
            };

            Collections.sort(p, ordemDecrescentePG);

            for(int i = 0; i < 4 ; i++){
                p.get(i).getEquipe().setIndicador("Libertadores");
            }

            for(int i = 19; i >15 ; i--){
                p.get(i).getEquipe().setIndicador("Rebaixado");
            }
            
            int ultimaRodada;
            int turnoDaRodada;
            if(c.getListaTurnos().get(1).getListaRodadas().isEmpty()){
                ultimaRodada = c.getListaTurnos().get(0).getListaRodadas().size()-1;
                turnoDaRodada = 0;
            }
            else{
                ultimaRodada = c.getListaTurnos().get(1).getListaRodadas().size()-1;
                turnoDaRodada = 1;
            }

            labelNumeroRodada.setText(String.valueOf(ultimaRodada));

            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
            }
            int q = 1;
            for(int i = 0; i < p.size() ; i++){    
                int posicao = q++;
                String indicador = p.get(i).getEquipe().getIndicador();
                String equipe = p.get(i).getEquipe().getNome();
                int pontosGanhos = p.get(i).getPontosGanhos();
                int jogos = p.get(i).getJogos();
                int vitoria = p.get(i).getVitorias();
                int empate = p.get(i).getEmpates();
                int derrota = p.get(i).getDerrotas();
                int golsPro = p.get(i).getGolsPro();
                int golsContra = p.get(i).getGolsContra();
                int saldo = p.get(i).getSaldo();
                double aproveitamento = p.get(i).getAproveitamento();
                Object dados [] = {posicao, indicador, equipe, pontosGanhos, jogos, vitoria, empate, derrota, golsPro, golsContra, saldo, aproveitamento};
                modelo.addRow(dados);
            }
        }*/
    }//GEN-LAST:event_btnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNumeroRodada;
    private javax.swing.JComboBox selecionarCampeonato;
    private javax.swing.JTable tabelaClassificacaoTurno2;
    // End of variables declaration//GEN-END:variables
}
