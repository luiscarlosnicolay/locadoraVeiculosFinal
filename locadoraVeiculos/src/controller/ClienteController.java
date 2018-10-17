/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import connection.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import models.Cliente;

/**
 *
 * @author Janquiel Kappler
 */
public class ClienteController {
    
    Cliente objCliente;  
    JTable jtbClientes = null;
    
    public ClienteController(Cliente objCliente, JTable jtbClientes) {
        this.objCliente = objCliente;
        this.jtbClientes = jtbClientes;
    }
    
    public void PreencheClientes() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("CPF/CNPJ");
        cabecalhos.add("Telefone");
        cabecalhos.add("Endereço");
        cabecalhos.add("Cidade");
        cabecalhos.add("UF");
        cabecalhos.add("Data de Nascimento");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT c.codcliente, c.nmcliente, c.cpf_cnpj, c.telefone, c.endereco, ci.nmcidade, ci.uf, c.dtnasc ";
            SQL += " FROM cliente c, cidade ci ";
            SQL += " WHERE c.codcid = ci.codcid ";
            SQL += " ORDER BY nmcliente ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add(result.getString(5));
                linha.add(result.getString(6));
                linha.add(result.getString(7));
                linha.add(result.getDate(8));
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Problemas para popular tabela!");
            System.out.println(e);
        }
        
        jtbClientes.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jtbClientes.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbClientes.getColumnModel().getColumn(i);
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
        
        jtbClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
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
    
    public Cliente buscarClientes(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT c.codcliente, c.nmcliente, c.cpf_cnpj, c.telefone, c.endereco, c.codcid, c.dtnasc ";
            SQL += " FROM cliente c ";
            SQL += " WHERE codcliente = '" + id + "'";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar aluno");
                
               objCliente = new Cliente();
               
                if(rs.next() == true)
                {
                    objCliente.setCodcliente(rs.getInt(1));
                    objCliente.setNmcliente(rs.getString(2));                                     
                    objCliente.setCpfcnpj(rs.getString(3));
                    objCliente.setTelefone(rs.getString(4));
                    objCliente.setEndereco(rs.getString(5));
                    objCliente.setCodcid(rs.getInt(6));
                    objCliente.setDtnasc(String.valueOf(rs.getDate(7)));
                    
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
        return objCliente;
    }
    
    public boolean incluirCliente(Cliente objCliente){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nmcliente, cpf_cnpj, telefone, endereco, dtnasc)VALUES(?,?,?,?,?)");
            stmt.setString(1, objCliente.getNmcliente());
            stmt.setString(2, objCliente.getCpfcnpj());
            stmt.setString(3, objCliente.getTelefone());
            stmt.setString(4, objCliente.getEndereco());
            stmt.setDate(5, Date.valueOf(objCliente.getDtnasc()));
            
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
            stmt = con.prepareStatement("UPDATE cliente SET nmcliente=?, cpf_cnpj=?, telefone=?, endereco=?, dtnasc=? WHERE codcliente=?");
            stmt.setInt(1, objCliente.getCodcliente());
            stmt.setString(2, objCliente.getNmcliente());
            stmt.setString(3, objCliente.getCpfcnpj());
            stmt.setString(4, objCliente.getTelefone());
            stmt.setString(5, objCliente.getEndereco());
            stmt.setDate(5, Date.valueOf(objCliente.getDtnasc()));
            
 
            stmt.executeUpdate();
 
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
 
    }
    public boolean excluirCliente(Cliente objCliente){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE codcliente = ? ");
            stmt.setInt(1, objCliente.getCodcliente());
            
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