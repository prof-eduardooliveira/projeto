/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author edube
 */
public class ViewEquipe extends javax.swing.JFrame {

    /**
     * Creates new form ViewEquipe
     */
    public ViewEquipe() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jbEnviarEmail = new javax.swing.JButton();
        jbEnviarEmail1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Eduardo Gomes de Oliveira");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Nielson Soares ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Tiago Bittencourt Nazare");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(9);
        jTextArea2.setTabSize(4);
        jTextArea2.setText("Possui graduação em Sistemas de Informação pelo Instituto Doctum de Educação e Tecnologia (2008) e Especialização em Redes de Comunicação pela Universidade Gama Filho. Atualmente é professor titular - Faculdades Integradas de Cataguases curso de Engenharia de Produção, Engenharia Elétrica, Administração, Ciências Contábeis e Logística, atuando ainda como responsável pelo departamento de Informática - Analista de T.I III - Faculdades Integradas de Cataguases. Professor titular das Faculdades Unificadas Doctum de Cataguases - curso: Sistemas de Informação. Tem experiência na área de Computação, com ênfase em Servidores Linux, gestão de processo utilizando simulação computacional com auxilio do software ARENA e Inteligência Artificial. Mestre em Gestão de Sistemas de Engenharia pela UCP (Universidade Católica de Petrópolis). Responsável pela empresa Júnior (FIC JUNIOR) e eventos relacionados a STARTUP.");
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(9);
        jTextArea3.setTabSize(4);
        jTextArea3.setText("Mestre em Engenharia Elétrica pela COPPE - Universidade Federal do Rio de Janeiro, na área de Redes de Computadores, sendo integrante do Grupo de Teleinformática e Automação (GTA) dessa instituição; Especialista em MBA em Gestão de Projetos de TI pela Universidade Federal de Juiz de Fora; Licenciado em Matemática pela Universidade de Franca e Bacharel em Sistemas de Informação pelas Faculdades Unificadas de Cataguases. Tem experiência na área de Ciência da Computação, com ênfase em Desenvolvimento de Software, Redes de Computadores e Desenvolvimento Mobile. Possui interesse nos seguintes temas de pesquisa: Informática na Educação, Computação Ubíqua e Pervasiva, Internet das Coisas, Interação Humano-Computador e Realidade Virtual e Aumentada.");
        jScrollPane3.setViewportView(jTextArea3);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(9);
        jTextArea4.setTabSize(4);
        jTextArea4.setText("Possui graduação em Engenharia de Controle e Automação pelo Centro Federal de Educação Tecnológica de Minas Gerais (2015) e Mestrado em Modelagem Computacional pela Universidade Federal de Juiz de Fora (2018). Tem experiência na área de Engenharia Elétrica, com ênfase em Controle e Automação, atuando principalmente nos seguintes temas: matlab, microcontroladores pic e sistemas dinâmicos. Experiência em Inteligência Computacional, atuando principalmente nos seguintes temas: aprendizado de máquina e mineração de dados. Grande conhecimento em ferramentas de programação como C, C++, Java e Python. E de programação web como PHP, HTML, CSS e JavaScript. Conhecimento também em Banco de Dados (MySQL). Atualmente, é professor substituto do Departamento de Computação e Mecânica no Centro Federal de Educação Tecnológica de Minas Gerais (CEFET-MG), campus Leopoldina, e também professor no curso de Sistemas de Informação na Rede de Ensino Doctum - Faculdades Unificadas de Cataguases. ");
        jScrollPane4.setViewportView(jTextArea4);

        jbEnviarEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/email.png"))); // NOI18N
        jbEnviarEmail.setText("Enviar E-mail");
        jbEnviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarEmailActionPerformed(evt);
            }
        });

        jbEnviarEmail1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/shape_square_edit.png"))); // NOI18N
        jbEnviarEmail1.setText("Enviar Zap");
        jbEnviarEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarEmail1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEnviarEmail)
                .addGap(29, 29, 29)
                .addComponent(jbEnviarEmail1)
                .addGap(431, 431, 431))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEnviarEmail)
                    .addComponent(jbEnviarEmail1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEnviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarEmailActionPerformed

    }//GEN-LAST:event_jbEnviarEmailActionPerformed

    private void jbEnviarEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEnviarEmail1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEquipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JButton jbEnviarEmail;
    private javax.swing.JButton jbEnviarEmail1;
    // End of variables declaration//GEN-END:variables
}