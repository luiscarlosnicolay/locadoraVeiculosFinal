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
import models.Veiculo;

/**
 *
 * @author luis_
 */
public class VeiculoController {
    
    Veiculo objVeiculo;  
    JTable jtbVeiculos = null;
    
    public VeiculoController(Veiculo objVeiculo, JTable jtbVeiculos) {
        this.objVeiculo = objVeiculo;
        this.jtbVeiculos = jtbVeiculos;
    }
    
    public void PreencheVeiculos() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Marca");
        cabecalhos.add("Modelo");
        cabecalhos.add("Ano");
        cabecalhos.add("KM");
        cabecalhos.add("QTDE Portas");
        cabecalhos.add("Cor");
        cabecalhos.add("Placa");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT  v.codveic, m.nmmarca, v.modelo, v.ano, v.km, v.qtdeportas, v.cor, v.placa ";
            SQL += " FROM veiculo v, marcaveic m ";
            SQL += " WHERE v.codmarca = m.codmarca ";
            SQL += " ORDER BY modelo ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getInt(4));
                linha.add(result.getInt(5));
                linha.add(result.getInt(6));
                linha.add(result.getString(7));
                linha.add(result.getString(8));
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas para popular tabela!");
            System.out.println(e);
        }
        
        jtbVeiculos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jtbVeiculos.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbVeiculos.getColumnModel().getColumn(i);
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
                case 3:
                    column.setPreferredWidth(30);
                    break;
                case 4:
                    column.setPreferredWidth(30);
                    break;
                case 5:
                    column.setPreferredWidth(30);
                    break;
                case 6:
                    column.setPreferredWidth(30);
                    break;
                case 7:
                    column.setPreferredWidth(30);
                    break;
            }
        }
        
        jtbVeiculos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
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
    
    public Veiculo buscarVeiculos(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT  v.codveic, m.codmarca, v.modelo, v.ano, v.km, v.qtdeportas, v.cor, v.placa ";
            SQL += " FROM veiculo v, marcaveic m ";
            SQL += " WHERE codveic = '" + id + "'";
            SQL += " AND v.codmarca = m.codmarca ";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar cliente");
                
               objVeiculo = new Veiculo();
               
                if(rs.next() == true)
                {
                    objVeiculo.setCodveic(rs.getInt(1));
                    objVeiculo.setCodmarca(rs.getInt(2));
                    objVeiculo.setModelo(rs.getString(3));                                     
                    objVeiculo.setAno(rs.getInt(4));
                    objVeiculo.setKm(rs.getInt(5));
                    objVeiculo.setQtdeportas(rs.getInt(6));
                    objVeiculo.setCor(rs.getString(7));
                    objVeiculo.setPlaca(rs.getString(8));                    
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
        
        System.out.println ("Executou buscar Veiculo com sucesso");
        return objVeiculo;
    }
    
    public boolean incluirVeiculo(Veiculo objVeiculo){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO veiculo (codmarca, modelo, ano, km, qtdeportas, cor, placa)VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, objVeiculo.getCodmarca());
            stmt.setString(2, objVeiculo.getModelo());
            stmt.setInt(3, objVeiculo.getAno());
            stmt.setInt(4, objVeiculo.getKm());
            stmt.setInt(5, objVeiculo.getQtdeportas());
            stmt.setString(6, objVeiculo.getCor());
            stmt.setString(7, objVeiculo.getPlaca());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean alterarVeiculo(){
 
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE veiculo SET codmarca=?, modelo=?, ano=?, km=?, qtdeportas=?, cor=?, placa=? WHERE codveic=?");
            stmt.setString(1, objVeiculo.getModelo());
            stmt.setInt(2, objVeiculo.getAno());
            stmt.setInt(3, objVeiculo.getKm());
            stmt.setInt(4, objVeiculo.getQtdeportas());
            stmt.setString(5, objVeiculo.getCor());
            stmt.setString(6, objVeiculo.getPlaca());
            stmt.setInt(7, objVeiculo.getCodveic());
            
 
            stmt.executeUpdate();
 
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 
    }
    
    public boolean excluirVeiculo(Veiculo objVeiculo){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM veiculo WHERE codveic = ? ");
            stmt.setInt(1, objVeiculo.getCodveic());
            
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
