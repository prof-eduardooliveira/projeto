/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerSolicitacaoGC;
import controller.ControllerUsuario;
import javax.swing.JOptionPane;
import model.ModelSolicitacaoGC;
import model.ModelUsuario;

/**
 *
 * @author Lara Guedes
 */
public class ViewLogin extends javax.swing.JFrame {

    ModelUsuario modelUsuario = new ModelUsuario();
    ControllerUsuario controllerUsuario = new ControllerUsuario();

    ModelSolicitacaoGC modelSolicitacaoGC = new ModelSolicitacaoGC();
    ControllerSolicitacaoGC controllerSolicitacaoGC = new ControllerSolicitacaoGC();

    /**
     * Creates new form ViewLogin
     */
    public ViewLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JPasswordField();
        jbConfirma = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 51, 255));
        setForeground(new java.awt.Color(204, 204, 255));
        setName("jfLogin"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuário:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));
        getContentPane().add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Senha:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));
        getContentPane().add(jtfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 230, -1));

        jbConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/key.png"))); // NOI18N
        jbConfirma.setText("Confirma");
        jbConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(jbConfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/page_paintbrush.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SGGC - Sistema Gerenciador de Grandes Clientes 1.0");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 16 x 16/login-background-images-png-3.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 250));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmaActionPerformed
        modelUsuario.setUsuario(jtfUsuario.getText());
        modelUsuario.setSenha(String.valueOf(jtfSenha.getPassword()));
        if (controllerUsuario.validarUsuario(modelUsuario)) {
            ViewPrincipal viewPrincipal = new ViewPrincipal();
            viewPrincipal.jlblUsuario.setText(modelUsuario.getUsuario().toUpperCase());
            String usuario = viewPrincipal.jlblUsuario.getText();
            System.out.println(usuario);
            modelSolicitacaoGC = controllerSolicitacaoGC.retQuantSolicUsua(viewPrincipal.jlblUsuario.getText());
            viewPrincipal.jlblNumeroSol.setText(String.valueOf(modelSolicitacaoGC.getTotal()));
            viewPrincipal.setVisible(true);
            //Runtime.getRuntime().exit(0);
            //ViewLogin viewLogin = new ViewLogin();
            //viewLogin.setDefaultCloseOperation(viewLogin.EXIT_ON_CLOSE);
            this.setVisible(false);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário/Senha inválidos!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbConfirmaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jbCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirma;
    private javax.swing.JPasswordField jtfSenha;
    public javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
