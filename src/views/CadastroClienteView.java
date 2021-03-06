/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.ClienteController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;
import tools.CaixaDeDialogo;
import tools.Combos;
import tools.Formatacao;
import tools.Validacao;

/**
 *
 * @author luis_
 */
public class CadastroClienteView extends javax.swing.JFrame {

    /**
     * Creates new form CadastrosView
     */
    
    Combos cbCidade;
    Cliente objCliente;
    
    
    public CadastroClienteView() {
        initComponents();
        
        try {
            //carregar os alunos existentes
            atualizarTabela();

            //carregar os cursos existentes
            
            txtUf.setEditable(false);
            cbCidade = new Combos(jcbCidade);
            cbCidade.PreencheCombo("SELECT codcid, nmcidade FROM cidade ORDER BY nmcidade");

            //limparTela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void atualizarTabela() {
        try {

            ClienteController clienteCon = new ClienteController(null, jtbClientes);
            clienteCon.PreencheClientes();
            Formatacao.colocaMascara(txtDtNasc, "##/##/####");

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    private void limparTela() {
        try {
            //LIMPAR OS CAMPOS DA TELA
            //LIBERAR O CAMPO MATRICULA
            cbCidade.SetaComboBox("");
            txtNome.setText("");
            txtCpfCnpj.setText("");
            txtDtNasc.setText("");
            txtTelefone.setText("");
            txtEndereco.setText("");
            txtDtNasc.setText("");
            txtUf.setText("");
            
            //Formata o campo data de nascimento
            Formatacao.colocaMascara(txtDtNasc, "##/##/####");
            
            //txtDataNascimento = Formatacao.getData();
            
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
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnIncluirCliente = new javax.swing.JButton();
        btnAlterarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        btnLimparTelaCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbClientes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        txtDtNasc = new javax.swing.JFormattedTextField();
        txtUf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Clientes");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF/CNPJ:");

        jLabel4.setText("Telefone:");

        jLabel6.setText("Endereço:");

        jLabel7.setText("Data de Nascimento:");

        btnIncluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-add.png"))); // NOI18N
        btnIncluirCliente.setText("Incluir");
        btnIncluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirClienteActionPerformed(evt);
            }
        });

        btnAlterarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        btnAlterarCliente.setText("Alterar");
        btnAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-delete.png"))); // NOI18N
        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        btnLimparTelaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/box.png"))); // NOI18N
        btnLimparTelaCliente.setText("Limpar");
        btnLimparTelaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTelaClienteActionPerformed(evt);
            }
        });

        jtbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbClientes);

        jLabel8.setText("Cidade:");

        jLabel9.setText("Estado:");

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIncluirCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparTelaCliente))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCpfCnpj))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEndereco))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDtNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluirCliente)
                    .addComponent(btnAlterarCliente)
                    .addComponent(btnExcluirCliente)
                    .addComponent(btnLimparTelaCliente))
                .addGap(115, 115, 115))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarClienteActionPerformed
        // TODO add your handling code here:
        try {
            if(validarDados() == true){

                guardarDados();

                ClienteController objClienteCon = new ClienteController(objCliente, null);
                
                if (objClienteCon.alterarCliente() == true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente alterado com Sucesso!");
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar cliente!");
                }

                limparTela();
                
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Campos inválidos"); 
                    return;
                }
                
            } catch (Exception ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarClienteActionPerformed

    private void btnIncluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirClienteActionPerformed
        // TODO add your handling code here:
            //PREENCHE O OBJETO CLIENTE
            try {
                if(validarDados() == true){

                    guardarDados();

                    ClienteController objClienteCon = new ClienteController(objCliente, null);
            
                    if (objClienteCon.incluirCliente(objCliente) == true) {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente incluído com Sucesso!");
                    } else {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir Cliente!");
                    }
                    
                    limparTela();
                    
                }else {
                        //CaixaDeDialogo.obterinstancia().exibirMensagem("Campos inválidos"); 
                        return;
                    }
                } catch (Exception ex) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }

    }//GEN-LAST:event_btnIncluirClienteActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        // TODO add your handling code here:
        ClienteController objClienteCon = new ClienteController(null, null);
        try {
            if (objClienteCon.excluirCliente(objCliente) == true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente removido com Sucesso!");
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao remover Cliente!");
            }
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
        
        limparTela();
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void preencheCampos() {
        try {
            txtNome.setText(objCliente.getNmcliente());
            txtCpfCnpj.setText(objCliente.getCpfcnpj());
            txtTelefone.setText(objCliente.getTelefone());
            txtEndereco.setText(objCliente.getEndereco());
            txtUf.setText(objCliente.getUf());
            cbCidade.SetaComboBox(String.valueOf(objCliente.getCodcid()));

            //Ajusta a data para DIA/MES/ANO
            String dataFormatada = Formatacao.ajustaDataDMA(objCliente.getDtnasc());
            txtDtNasc.setText(dataFormatada);

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    private void jtbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbClientesMouseClicked
        // TODO add your handling code here:
        try {

            //pega a linha selecionada
            int linhaSelecionada = jtbClientes.getSelectedRow();
            // Primeira coluna da linha
            String coluna1 = jtbClientes.getModel().getValueAt(linhaSelecionada, 0).toString();

            //basta agora chamar o método buscar, passando o COLUNA1 como parâmetro de consulta
            ClienteController objClienteCon = new ClienteController(null, null);
            objCliente = objClienteCon.buscarClientes(coluna1);

            preencheCampos();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtbClientesMouseClicked

    private void btnLimparTelaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTelaClienteActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparTelaClienteActionPerformed

    private void guardarDados() {
        
        try {
             if (objCliente == null) {
                objCliente = new Cliente();
            }
            objCliente.setNmcliente(txtNome.getText());
            objCliente.setCpfcnpj(txtCpfCnpj.getText());
            objCliente.setTelefone(txtTelefone.getText());
            objCliente.setEndereco(txtEndereco.getText());
            
            //AJUSTA A DATA PARA ANO-MES-DIA PARA GRAVAR NO BANCO
            String dataFormatada = Formatacao.ajustaDataAMD(txtDtNasc.getText());
            objCliente.setDtnasc(dataFormatada);
            
            //RECUPERANDO A CIDADE DO CLIENTE
            Combos c = (Combos) jcbCidade.getSelectedItem();
            String codigoCidade = c.getCodigo();
            objCliente.setCodcid(Integer.parseInt(codigoCidade));

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
    
    private boolean validarDados() {
        try {
            //VALIDAR O CAMPOS DA TELA
            //RETURN FALSE SE ALGUM CAMPO NAO ESTA PREENCHIDO CORRETAMENTE
            if((txtNome.getText().trim().length()) < 50 && (txtNome.getText().trim().equals(""))){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Nome Incorreto", "Atenção", 'e');
                return false;
            }
            if((txtEndereco.getText().trim().length()) < 50 && (txtEndereco.getText().trim().equals(""))){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Endereço maior que 50 caracteres", "Atenção", 'e');
                return false;
            }
            if(txtDtNasc.getText().equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Data Inválida", "Atenção", 'e');
                return false;
            }
            if(jcbCidade.getSelectedIndex() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Selecione uma Cidade", "Atenção", 'e');
                return false;
            }
            
            String wCodigo = txtCpfCnpj.getText().toString();
            if(wCodigo.length() == 11){
                Boolean wRet = Validacao.validarCPF(wCodigo);
                if(wRet == false){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("CPF incorreto", "Atenção", 'e');
                    return false;
                }
            }else if(wCodigo.length() == 14){
                Boolean wRet = Validacao.validarCNPJ(wCodigo);
                if(wRet == false){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("CNPJ incorreto", "Atenção", 'e');
                    return false;
                }
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF ou CNPJ correto", "Atenção", 'e');
                return false;
            }
            if(Validacao.validarTelefone(txtTelefone)){
                //sucesso
                //return true;
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Atenção", "Telefone incorreto", 'e');
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
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarCliente;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnIncluirCliente;
    private javax.swing.JButton btnLimparTelaCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JTable jtbClientes;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JFormattedTextField txtDtNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
