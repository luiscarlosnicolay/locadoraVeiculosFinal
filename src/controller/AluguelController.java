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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Aluguel;

/**
 *
 * @author luis_
 */
public class AluguelController {
    
    Aluguel objAluguel;  
    JTable jtbAluguel = null;
    
    public AluguelController(Aluguel objAluguel, JTable jtbAluguel) {
        this.objAluguel = objAluguel;
        this.jtbAluguel = jtbAluguel;
    }
    
    public void PreencheAlugueis() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Veículo");
        cabecalhos.add("Cliente");
        cabecalhos.add("Tipo Pagamento");
        cabecalhos.add("Login");
        cabecalhos.add("KM Inicio");
        cabecalhos.add("KM Fim");
        cabecalhos.add("Data Inicio");
        cabecalhos.add("Data Fim");
        cabecalhos.add("VL Diária");
        cabecalhos.add("VL KM Add.");
        cabecalhos.add("VL Total");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT a.codaluguel, v.modelo, c.nmcliente, tp.tipotppag, u.login, a.kminicio, a.kmfim, a.dtinicio, a.dtfim, a.vldiaria, a.vlkmadicional, a.vltotal ";
            SQL += " FROM aluguel a, veiculo v, cliente c, tppagamento tp, usuarios u";
            SQL += " WHERE a.codveic = v.codveic ";
            SQL += " AND a.codcliente = c.codcliente ";
            SQL += " AND a.codtppagamento = tp.codtppagamento ";
            SQL += " AND a.login = u.login ";
            SQL += " ORDER BY nmcliente ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add(result.getString(5));
                linha.add(result.getInt(6));
                linha.add(result.getInt(7));
                linha.add(result.getDate(8));
                linha.add(result.getDate(9));
                linha.add(result.getDouble(10));
                linha.add(result.getDouble(11));
                linha.add(result.getDouble(12));
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas para popular tabela!");
            System.out.println(e);
        }
        
        jtbAluguel.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jtbAluguel.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbAluguel.getColumnModel().getColumn(i);
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
                case 8:
                    column.setPreferredWidth(30);
                    break;
                case 9:
                    column.setPreferredWidth(30);
                    break;
                case 10:
                    column.setPreferredWidth(30);
                    break;
                case 11:
                    column.setPreferredWidth(30);
                    break;
                case 12:
                    column.setPreferredWidth(30);
                    break;
            }
        }
        
        jtbAluguel.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
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
    
    public Aluguel buscarAluguel(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT a.codaluguel, v.modelo, c.nmcliente, tp.tipotppag, u.login, a.kminicio, a.kmfim, a.dtinicio, a.dtfim, a.vldiaria, a.vlkmadicional, a.vltotal ";
            SQL += " FROM aluguel a, veiculo v, cliente c, tppagamento tp, usuarios u";
            SQL += " WHERE a.codaluguel = '" + id + "' ";
            SQL += " AND a.codveic = v.codveic ";
            SQL += " AND a.codcliente = c.codcliente ";
            SQL += " AND a.codtppagamento = tp.codtppagamento ";
            SQL += " AND a.login = u.login ";
            SQL += " ORDER BY nmcliente ";

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar cliente");
                
               objAluguel = new Aluguel();
               
                if(rs.next() == true)
                {
                    objAluguel.setCodaluguel(rs.getInt(1));
                    objAluguel.setCodveic(rs.getInt(2));                                     
                    objAluguel.setCodcliente(rs.getInt(3));
                    objAluguel.setCodtppagamento(rs.getInt(4));
                    objAluguel.setLogin(rs.getString(5));
                    objAluguel.setKminicio(rs.getInt(6));
                    objAluguel.setKmfim(rs.getInt(7));
                    objAluguel.setDtinicio(String.valueOf(rs.getDate(8)));
                    objAluguel.setDtfim(String.valueOf(rs.getDate(9)));
                    objAluguel.setVldiaria(rs.getDouble(10));
                    objAluguel.setVlkmadicional(rs.getDouble(11));
                    objAluguel.setVltotal(rs.getDouble(12));                   
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
        
        System.out.println ("Executou buscar aluno com sucesso");
        return objAluguel;
    }
    
    public boolean incluirAluguel(Aluguel objAluguel){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO aluguel (codveic, codcliente, codtppagamento, login, kminicio, kmfim, dtinicio, dtfim, vldiaria, vlkmadicinal, vltotal)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, objAluguel.getCodveic());
            stmt.setInt(2, objAluguel.getCodcliente());
            stmt.setInt(3, objAluguel.getCodtppagamento());
            stmt.setString(4, objAluguel.getLogin());
            stmt.setInt(5, objAluguel.getKminicio());
            stmt.setInt(6, objAluguel.getKmfim());
            stmt.setDate(7, Date.valueOf(objAluguel.getDtinicio()));
            stmt.setDate(8, Date.valueOf(objAluguel.getDtfim()));
            stmt.setDouble(9, objAluguel.getVldiaria());
            stmt.setDouble(10, objAluguel.getVlkmadicional());
            stmt.setDouble(11, objAluguel.getVltotal());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }
    
    public boolean alterarCliente(){
 
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE aluguel SET codveic=?, codcliente=?, codtppagamento=?, login=?, kminicio=?, kmfim=?, dtinicio=?, dtfim=?, vldiaria=?, vlkmadicinal=?, vltotal=? WHERE codaluguel=?");
            stmt.setInt(1, objAluguel.getCodveic());
            stmt.setInt(2, objAluguel.getCodcliente());
            stmt.setInt(3, objAluguel.getCodtppagamento());
            stmt.setString(4, objAluguel.getLogin());
            stmt.setInt(5, objAluguel.getKminicio());
            stmt.setInt(6, objAluguel.getKmfim());
            stmt.setDate(7, Date.valueOf(objAluguel.getDtinicio()));
            stmt.setDate(8, Date.valueOf(objAluguel.getDtfim()));
            stmt.setDouble(9, objAluguel.getVldiaria());
            stmt.setDouble(10, objAluguel.getVlkmadicional());
            stmt.setDouble(11, objAluguel.getVltotal());
            stmt.setInt(12, objAluguel.getCodaluguel());
            
 
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
