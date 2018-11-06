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
import models.MarcaVeiculo;

/**
 *
 * @author luis_
 */
public class MarcaVeiculoController {
    
    MarcaVeiculo objMarcaVeiculo;
    JTable jtbMarcaVeiculo = null;
    
    public MarcaVeiculoController(MarcaVeiculo objMarcaVeiculo, JTable jtbMarcaVeiculo) {
        this.objMarcaVeiculo = objMarcaVeiculo;
        this.jtbMarcaVeiculo = jtbMarcaVeiculo;
    }
    
    public void PreencheMarcaVeiculo() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Marca");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT mv.codmarca, mv.nmmarca ";
            SQL += " FROM marcaveic mv ";
            SQL += " ORDER BY nmmarca ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas para popular tabela!");
            System.out.println(e);
        }
        
        jtbMarcaVeiculo.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jtbMarcaVeiculo.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = jtbMarcaVeiculo.getColumnModel().getColumn(i);
            switch (1) {
                case 0:
                    column.setPreferredWidth(20);
                    break;
                case 1:
                    column.setPreferredWidth(20);
                    break;
            }
        }
        
        jtbMarcaVeiculo.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
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
    }
    
    public MarcaVeiculo buscarMarcaVeiculo(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT mv.codmarca, mv.nmmarca ";
            SQL += " FROM marcaveic mv ";
            SQL += " WHERE codmarca = '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar Marca de Veículo");
                
               objMarcaVeiculo = new MarcaVeiculo();
               
                if(rs.next() == true)
                {
                    objMarcaVeiculo.setCodmarca(rs.getInt(1));
                    objMarcaVeiculo.setNmmarrca(rs.getString(2));                                                
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
        
        System.out.println ("Executou buscar Marca de Veículo com sucesso");
        return objMarcaVeiculo;
    }
    
    public boolean incluirMarcaVeiculo(MarcaVeiculo objMarcaVeiculo){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO marcaveic (nmmarca)VALUES(?)");
            stmt.setString(1, objMarcaVeiculo.getNmmarrca());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean alterarMarcaVeiculo(){
 
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE marcaveic SET nmmarca=? WHERE codmarca=?");
            stmt.setString(1, objMarcaVeiculo.getNmmarrca());
            stmt.setInt(2, objMarcaVeiculo.getCodmarca());
 
            stmt.executeUpdate();
 
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 
    }
    
    public boolean excluirMarcaVeiculo(MarcaVeiculo objMarcaVeiculo){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM marcaveic WHERE codmarca = ? ");
            stmt.setInt(1, objMarcaVeiculo.getCodmarca());
            
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
