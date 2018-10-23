/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.TpPagamento;

/**
 *
 * @author luis_
 */
public class TpPagamentoController {
    
    TpPagamento objTpPagamento;  
    JTable jtbTpPagamento = null;
    
    public TpPagamentoController(TpPagamento objTpPagamento, JTable jtbTipoPagamento) {
        this.objTpPagamento = objTpPagamento;
        this.jtbTpPagamento = jtbTipoPagamento;
    }
    
    public void PreencheTpPagamento() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Tipo");
        cabecalhos.add("Descrição");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT tpp.codtppag, tpp.tipotppag, tpp.desctppag";
            SQL += " FROM tppagamento tpp ";
            SQL += " ORDER BY tipotppag ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas para popular tabela!");
            System.out.println(e);
        }
        
        jtbTpPagamento.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jtbTpPagamento.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbTpPagamento.getColumnModel().getColumn(i);
            switch (1) {
                case 0:
                    column.setPreferredWidth(20);
                    break;
                case 1:
                    column.setPreferredWidth(20);
                    break;
                case 2:
                    column.setPreferredWidth(50);
                    break;
            }
        }
        
        jtbTpPagamento.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    setBackground(Color.GREEN);
                    //setForeground(Color.BLUE);
                }
                else if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }
    
    public TpPagamento buscarTpPagamento(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT tpp.codtppag, tpp.tipotppag, tpp.desctppag";
            SQL += " FROM tppagamento tpp ";
            SQL += " WHERE codtppag = '" + id + "'";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar tipo de pagamento");
                
               objTpPagamento = new TpPagamento();
               
                if(rs.next() == true)
                {
                    objTpPagamento.setCodtppag(rs.getInt(1));
                    objTpPagamento.setTipotppag(rs.getString(2));
                    objTpPagamento.setDesctppag(rs.getString(3));                                                      
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar tipo de pagamento com sucesso");
        return objTpPagamento;
    }
    
    public boolean incluirTpPagamento(TpPagamento objTpPagamento){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tppagamento (tipotppag, desctppag)VALUES(?,?)");
            stmt.setString(1, objTpPagamento.getTipotppag());
            stmt.setString(2, objTpPagamento.getDesctppag());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean alterarTpPagamento(){
 
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE tppagamento SET tipotppag=?, desctppag=? WHERE codtppag=?");
            stmt.setString(1, objTpPagamento.getTipotppag());
            stmt.setString(2, objTpPagamento.getDesctppag());
            stmt.setInt(3, objTpPagamento.getCodtppag());
 
            stmt.executeUpdate();
 
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 
    }
    public boolean excluirTpPagamento(TpPagamento objTpPagamento){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tppagamento WHERE codtppag = ? ");
            stmt.setInt(1, objTpPagamento.getCodtppag());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
