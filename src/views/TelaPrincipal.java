/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import tools.CaixaDeDialogo;

/**
 *
 * @author luis_
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrinciapl
     */
    public TelaPrincipal() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenuCidades = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenuItem();
        jMenuTpPagamento = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuMovimentos = new javax.swing.JMenu();
        jMenuItemAlugueis = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuItemRelClientes = new javax.swing.JMenuItem();
        jMenuItemRelVeiculos = new javax.swing.JMenuItem();
        jMenuItemCidades = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/notepad.png"))); // NOI18N
        jMenuCadastros.setText("Cadastros");

        jMenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile-group.png"))); // NOI18N
        jMenuClientes.setText("Clientes");
        jMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClientesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuClientes);

        jMenuCidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/map-map-marker.png"))); // NOI18N
        jMenuCidades.setText("Cidades");
        jMenuCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCidadesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuCidades);

        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user-male-alt.png"))); // NOI18N
        jMenuUsuarios.setText("Usuários");
        jMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuUsuarios);

        jMenuTpPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money.png"))); // NOI18N
        jMenuTpPagamento.setText("Tipos de Pagamento");
        jMenuTpPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTpPagamentoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuTpPagamento);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/layers.png"))); // NOI18N
        jMenuItem3.setText("Marca de Veículo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItem3);

        jMenuBar1.add(jMenuCadastros);

        jMenuMovimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-sync.png"))); // NOI18N
        jMenuMovimentos.setText("Movimentos");

        jMenuItemAlugueis.setText("Aluguéis");
        jMenuItemAlugueis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlugueisActionPerformed(evt);
            }
        });
        jMenuMovimentos.add(jMenuItemAlugueis);

        jMenuBar1.add(jMenuMovimentos);

        jMenuRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file-bookmark.png"))); // NOI18N
        jMenuRelatorios.setText("Relatórios");

        jMenuItemRelClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file-pdf.png"))); // NOI18N
        jMenuItemRelClientes.setText("Clientes");
        jMenuItemRelClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelClientesActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelClientes);

        jMenuItemRelVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file-pdf.png"))); // NOI18N
        jMenuItemRelVeiculos.setText("Veículos");
        jMenuItemRelVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelVeiculosActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemRelVeiculos);

        jMenuItemCidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file-pdf.png"))); // NOI18N
        jMenuItemCidades.setText("Cidades");
        jMenuItemCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCidadesActionPerformed(evt);
            }
        });
        jMenuRelatorios.add(jMenuItemCidades);

        jMenuBar1.add(jMenuRelatorios);

        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-error.png"))); // NOI18N
        jMenuSair.setText("Sair");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-error.png"))); // NOI18N
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItem4);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCidadesActionPerformed
        // TODO add your handling code here:
        CadastroCidadeView cadastrocidade = new CadastroCidadeView();
        cadastrocidade.setVisible(true);
    }//GEN-LAST:event_jMenuCidadesActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClientesActionPerformed
        // TODO add your handling code here:
        CadastroClienteView cadastrocliente = new CadastroClienteView();
        cadastrocliente.setVisible(true);
    }//GEN-LAST:event_jMenuClientesActionPerformed

    private void jMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuariosActionPerformed
        // TODO add your handling code here:
        CadastroUsuariosView usuarioview = new CadastroUsuariosView();
        usuarioview.setVisible(true);
    }//GEN-LAST:event_jMenuUsuariosActionPerformed

    private void jMenuTpPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTpPagamentoActionPerformed
        // TODO add your handling code here:
        CadastroTpPagamentoView tppagamentoview = new CadastroTpPagamentoView();
        tppagamentoview.setVisible(true);
    }//GEN-LAST:event_jMenuTpPagamentoActionPerformed

    private void jMenuItemAlugueisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlugueisActionPerformed
        // TODO add your handling code here:
        CaixaDeDialogo.obterinstancia().exibirMensagem("Versão Demo, em breve versão de produção");
    }//GEN-LAST:event_jMenuItemAlugueisActionPerformed

    private void jMenuItemRelClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelClientesActionPerformed
        // TODO add your handling code here:
        RelClientesView relclientesview = new RelClientesView();
        relclientesview.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelClientesActionPerformed

    private void jMenuItemCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCidadesActionPerformed
        // TODO add your handling code here:
        RelCidadesView relcidadesview = new RelCidadesView();
        relcidadesview.setVisible(true);
    }//GEN-LAST:event_jMenuItemCidadesActionPerformed

    private void jMenuItemRelVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelVeiculosActionPerformed
        // TODO add your handling code here:
        RelVeiculosView relveiculosview = new RelVeiculosView();
        relveiculosview.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelVeiculosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        CadastroMarcaVeiculoView cadastromarcaveiculoview = new CadastroMarcaVeiculoView();
        cadastromarcaveiculoview.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuCidades;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAlugueis;
    private javax.swing.JMenuItem jMenuItemCidades;
    private javax.swing.JMenuItem jMenuItemRelClientes;
    private javax.swing.JMenuItem jMenuItemRelVeiculos;
    private javax.swing.JMenu jMenuMovimentos;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenuItem jMenuTpPagamento;
    private javax.swing.JMenuItem jMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
