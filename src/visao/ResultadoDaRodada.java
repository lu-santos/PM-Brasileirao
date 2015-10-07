/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import controlador.ResultadoRodadaEvent;
import modelo.entidade.Jogo;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucianna
 */
public class ResultadoDaRodada extends javax.swing.JInternalFrame {

    /**
     * Creates new form ResultadoDaRodada
     */
    
    private ObjectTableModel modelo;
    private ResultadoRodadaEvent classificacao = new ResultadoRodadaEvent();
    private Integer anoDoCampeonato;
    private int numeroRodada;
    
    public ResultadoDaRodada() {
        initComponents();
        
        try {
            FuncoesPadroes.addListModelCampeonato(classificacao, selecionarCampeonato);
        } catch (Exception ex) {
            FuncoesPadroes.exibirMensagem(getContentPane(), "Importe o campeonato!");    
            Logger.getLogger(ClassificacaoCampeonato.class.getName()).log(Level.SEVERE, null, ex);
        }        
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
        tabelaCampeonatoRodada = new javax.swing.JScrollPane();
        tabelaResultadoRodada = new javax.swing.JTable();
        btnOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selecionarRodada = new javax.swing.JComboBox();
        btnVoltarRodada = new javax.swing.JButton();
        btnAvancarRodada = new javax.swing.JButton();
        btnOKCamp = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Resultado da Rodada");
        setMinimumSize(new java.awt.Dimension(1020, 380));
        setPreferredSize(new java.awt.Dimension(1020, 380));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Campeonato");

        selecionarCampeonato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tabelaResultadoRodada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaResultadoRodada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCampeonatoRodada.setViewportView(tabelaResultadoRodada);
        if (tabelaResultadoRodada.getColumnModel().getColumnCount() > 0) {
            tabelaResultadoRodada.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tabelaResultadoRodada.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tabelaResultadoRodada.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tabelaResultadoRodada.getColumnModel().getColumn(3).setHeaderValue("null");
        }

        btnOk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Rodada");

        selecionarRodada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnVoltarRodada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVoltarRodada.setText("<<");
        btnVoltarRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarRodadaActionPerformed(evt);
            }
        });

        btnAvancarRodada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAvancarRodada.setText(">>");
        btnAvancarRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarRodadaActionPerformed(evt);
            }
        });

        btnOKCamp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnOKCamp.setText("OK");
        btnOKCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKCampActionPerformed(evt);
            }
        });

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
                .addComponent(btnOKCamp)
                .addGap(218, 218, 218)
                .addComponent(btnVoltarRodada)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selecionarRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAvancarRodada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addContainerGap())
            .addComponent(tabelaCampeonatoRodada, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
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
                    .addComponent(selecionarRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltarRodada)
                    .addComponent(btnAvancarRodada)
                    .addComponent(btnOKCamp))
                .addGap(18, 18, 18)
                .addComponent(tabelaCampeonatoRodada, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        anoDoCampeonato = Integer.valueOf((String) selecionarCampeonato.getSelectedItem());
        numeroRodada = Integer.valueOf((String) selecionarRodada.getSelectedItem());
        addJogosNaTabela();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnVoltarRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarRodadaActionPerformed
        anoDoCampeonato = Integer.valueOf((String) selecionarCampeonato.getSelectedItem());
        if (numeroRodada > 1) {
            numeroRodada = numeroRodada-1;
            selecionarRodada.setSelectedIndex(selecionarRodada.getSelectedIndex()-1);
        }
        addJogosNaTabela();
    }

    private void addJogosNaTabela() {
        try {
            List<Jogo> jogos = classificacao.getListaDeJogos(anoDoCampeonato, numeroRodada);
            modelo = new ObjectTableModel(jogos);
            tabelaResultadoRodada.setModel(modelo); 
        } catch (Exception ex) {
            FuncoesPadroes.exibirMensagem(getContentPane(), "Importe o campeonato!"); 
            Logger.getLogger(ClassificacaoCampeonato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVoltarRodadaActionPerformed

    private void btnAvancarRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarRodadaActionPerformed
        anoDoCampeonato = Integer.valueOf((String) selecionarCampeonato.getSelectedItem());
        if (numeroRodada < 38 && numeroRodada > 0) {
            numeroRodada = numeroRodada+1;
            selecionarRodada.setSelectedIndex(selecionarRodada.getSelectedIndex()+1);
        }
        addJogosNaTabela();
    }//GEN-LAST:event_btnAvancarRodadaActionPerformed

    private void btnOKCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKCampActionPerformed
        anoDoCampeonato = Integer.valueOf(String.valueOf(selecionarCampeonato.getSelectedItem()));
        try {
            FuncoesPadroes.addListModelRodada(classificacao, selecionarRodada, anoDoCampeonato);
        } catch (Exception ex) {
            Logger.getLogger(ResultadoDaRodada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOKCampActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancarRodada;
    private javax.swing.JButton btnOKCamp;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnVoltarRodada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox selecionarCampeonato;
    private javax.swing.JComboBox selecionarRodada;
    private javax.swing.JScrollPane tabelaCampeonatoRodada;
    private javax.swing.JTable tabelaResultadoRodada;
    // End of variables declaration//GEN-END:variables
}
