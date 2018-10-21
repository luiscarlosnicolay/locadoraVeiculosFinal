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
import models.Cidade;

/**
 *
 * @author luis_
 */
public class CidadeController {
    
    Cidade objCidade;  
    JTable jtbCidade = null;
    
    public CidadeController(Cidade objCidade, JTable jtbCidade) {
        this.objCidade = objCidade;
        this.jtbCidade = jtbCidade;
    }
    
    public void PreencheCidades() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Nome");
        cabecalhos.add("CEP");
        cabecalhos.add("UF");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT ci.nmcidade, ci.cep, ci.uf ";
            SQL += " FROM cidade ci ";
            SQL += " ORDER BY nmcidade ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getString(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas para popular tabela!");
            System.out.println(e);
        }
        
        jtbCidade.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jtbCidade.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbCidade.getColumnModel().getColumn(i);
            switch (1) {
                case 0:
                    column.setPreferredWidth(30);
                    break;
                case 1:
                    column.setPreferredWidth(50);
                    break;
                case 2:
                    column.setPreferredWidth(30);
                    break;
            }
        }
        
        jtbCidade.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
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
    
    public Cidade buscarCidades(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT ci.codcid, ci.nmcidade, ci.cep, ci.uf ";
            SQL += " FROM cidade ci ";
            SQL += " WHERE codcid = '" + id + "'";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar cidade");
                
               objCidade = new Cidade();
               
                if(rs.next() == true)
                {
                    objCidade.setNmcidade(rs.getString(1));
                    objCidade.setCep(rs.getString(2));                                     
                    objCidade.setUf(rs.getString(3));                   
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
        
        System.out.println ("Executou buscar cidade com sucesso");
        return objCidade;
    }
    
    public boolean incluirCidade(Cidade objCidade){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cidade (nmcidade, cep, uf)VALUES(?,?,?)");
            stmt.setString(1, objCidade.getNmcidade());
            stmt.setString(2, objCidade.getCep());
            stmt.setString(3, objCidade.getUf());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean alterarCidade(){
 
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE cidade SET nmcidade=?, cep=?, uf=? WHERE codcid=?");
            stmt.setString(1, objCidade.getNmcidade());
            stmt.setString(2, objCidade.getCep());
            stmt.setString(3, objCidade.getUf());            
 
            stmt.executeUpdate();
 
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 
    }
    public boolean excluirCidade(Cidade objCidade){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cidade WHERE codcid = ? ");
            stmt.setInt(1, objCidade.getCodcid());
            
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
