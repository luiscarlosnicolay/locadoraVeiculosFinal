/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.MarcaVeiculoController;
import models.MarcaVeiculo;
import tools.CaixaDeDialogo;

/**
 *
 * @author luis_
 */
public class CadastroMarcaVeiculoView extends javax.swing.JFrame {
    
    MarcaVeiculo objMarcaVeiculo;
    

    /**
     * Creates new form CadastroMarcaVeiculo
     */
    public CadastroMarcaVeiculoView() {
        initComponents();
        
        try {
            atualizarTabela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void atualizarTabela() {
        try {

            MarcaVeiculoController MarcaVeiculoCon = new MarcaVeiculoController(null, jtbMarcaVeiculo);
            MarcaVeiculoCon.PreencheMarcaVeiculo();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void limparTela() {
        try {
            //LIMPAR OS CAMPOS DA TELA
            txtCodigoMarcaVeiculo.setText("");
            txtMarcaVeiculo.setText("");
            
            atualizarTabela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoMarcaVeiculo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarcaVeiculo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMarcaVeiculo = new javax.swing.JTable();
        btnIncluirMarcaVeiculo = new javax.swing.JButton();
        btnAlterarMarcaVeiculo = new javax.swing.JButton();
        btnExcluirMarcaVeiculo = new javax.swing.JButton();
        btnLimparMarcaVeiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Marcas de Veículos");

        jLabel2.setText("Código:");

        txtCodigoMarcaVeiculo.setEditable(false);
        txtCodigoMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoMarcaVeiculoActionPerformed(evt);
            }
        });

        jLabel3.setText("Marca:");

        txtMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaVeiculoActionPerformed(evt);
            }
        });

        jtbMarcaVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbMarcaVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMarcaVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbMarcaVeiculo);

        btnIncluirMarcaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-add.png"))); // NOI18N
        btnIncluirMarcaVeiculo.setText("Incluir");
        btnIncluirMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirMarcaVeiculoActionPerformed(evt);
            }
        });

        btnAlterarMarcaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        btnAlterarMarcaVeiculo.setText("Alterar");
        btnAlterarMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarMarcaVeiculoActionPerformed(evt);
            }
        });

        btnExcluirMarcaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-delete.png"))); // NOI18N
        btnExcluirMarcaVeiculo.setText("Excluir");
        btnExcluirMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMarcaVeiculoActionPerformed(evt);
            }
        });

        btnLimparMarcaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/box.png"))); // NOI18N
        btnLimparMarcaVeiculo.setText("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIncluirMarcaVeiculo)
                .addGap(18, 18, 18)
                .addComponent(btnAlterarMarcaVeiculo)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirMarcaVeiculo)
                .addGap(18, 18, 18)
                .addComponent(btnLimparMarcaVeiculo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluirMarcaVeiculo)
                    .addComponent(btnAlterarMarcaVeiculo)
                    .addComponent(btnExcluirMarcaVeiculo)
                    .addComponent(btnLimparMarcaVeiculo))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoMarcaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMarcaVeiculoActionPerformed

    private void txtMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaVeiculoActionPerformed

    private void btnIncluirMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirMarcaVeiculoActionPerformed
        // TODO add your handling code here:
        try {
            if(validarDados() == true){

            guardarDados();

                MarcaVeiculoController objMarcaVeiculoCon = new MarcaVeiculoController(objMarcaVeiculo, null);

                    if (objMarcaVeiculoCon.incluirMarcaVeiculo(objMarcaVeiculo) == true) {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Marca de Veículo incluída com Sucesso!");
                    } else {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir marca de veículo!");
                    }
                    
                    limparTela();
                    
                    }else {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Campos inválidos"); 
                        return;
                    }
                    
            } catch (Exception ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnIncluirMarcaVeiculoActionPerformed

    private void btnAlterarMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarMarcaVeiculoActionPerformed
        // TODO add your handling code here:
        try {
            if(validarDados() == true){
            
                guardarDados();

                MarcaVeiculoController objMarcaVeiculoCon = new MarcaVeiculoController(objMarcaVeiculo, null);

                if (objMarcaVeiculoCon.alterarMarcaVeiculo()== true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Marca de Veículo alterada com Sucesso!");
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar Marca de Veículo!");
                }
                
                limparTela();
                
                }else {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Campos inválidos"); 
                        return;
                    }            
            } catch (Exception ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarMarcaVeiculoActionPerformed

    private void btnExcluirMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMarcaVeiculoActionPerformed
        // TODO add your handling code here:
        MarcaVeiculoController objMarcaVeiculoCon = new MarcaVeiculoController(null, null);
        try {
            if (objMarcaVeiculoCon.excluirMarcaVeiculo(objMarcaVeiculo) == true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Marca de Veículo removida com Sucesso!");
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao remover Marca de Veículo!");
            }
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
        
        limparTela();
    }//GEN-LAST:event_btnExcluirMarcaVeiculoActionPerformed

    private void jtbMarcaVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMarcaVeiculoMouseClicked
        // TODO add your handling code here:
        try {

            //pega a linha selecionada
            int linhaSelecionada = jtbMarcaVeiculo.getSelectedRow();
            // Primeira coluna da linha
            String coluna1 = jtbMarcaVeiculo.getModel().getValueAt(linhaSelecionada, 0).toString();

            //basta agora chamar o método buscar, passando o COLUNA1 como parâmetro de consulta
            MarcaVeiculoController objMarcaVeiculoCon = new MarcaVeiculoController(null, null);
            objMarcaVeiculo = objMarcaVeiculoCon.buscarMarcaVeiculo(coluna1);

            preencheCampos();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtbMarcaVeiculoMouseClicked

    private void preencheCampos() {
        try {
            txtCodigoMarcaVeiculo.setText(String.valueOf(objMarcaVeiculo.getCodmarca()));
            txtMarcaVeiculo.setText(objMarcaVeiculo.getNmmarrca());

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    private void guardarDados() {
        try {
            if (objMarcaVeiculo == null) {
                objMarcaVeiculo = new MarcaVeiculo();
            }
            objMarcaVeiculo.setNmmarrca(txtMarcaVeiculo.getText());

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
    
    private boolean validarDados() {
        try {
            //VALIDAR O CAMPOS DA TELA
            //RETURN FALSE SE ALGUM CAMPO NAO ESTA PREENCHIDO CORRETAMENTE
            if((txtMarcaVeiculo.getText().trim().length()) < 30 && (txtMarcaVeiculo.getText().trim().equals(""))){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Marca Incorreta", "Atenção", 'e');
                return false;
            }
            return true;
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            return false;
        }
    }
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
            java.util.logging.Logger.getLogger(CadastroMarcaVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMarcaVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMarcaVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMarcaVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMarcaVeiculoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarMarcaVeiculo;
    private javax.swing.JButton btnExcluirMarcaVeiculo;
    private javax.swing.JButton btnIncluirMarcaVeiculo;
    private javax.swing.JButton btnLimparMarcaVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtbMarcaVeiculo;
    private javax.swing.JTextField txtCodigoMarcaVeiculo;
    private javax.swing.JTextField txtMarcaVeiculo;
    // End of variables declaration//GEN-END:variables
}