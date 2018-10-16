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
        cabecalhos.add("Data de Nascimento");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT c.codcliente, c.nmcliente, c.cpf_cnpj, c.telefone, c.endereco, c.codcid, c.dtnasc ";
            SQL += " FROM cliente c ";
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
                linha.add(result.getDate(7));
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
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(150);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
                case 3:
                    column.setPreferredWidth(150);
                    break;
                case 4:
                    column.setPreferredWidth(150);
                    break;
                case 5:
                    column.setPreferredWidth(150);
                    break;
                case 6:
                    column.setPreferredWidth(150);
                    break;
                case 7:
                    column.setPreferredWidth(150);
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
                    objCliente.setCodcid(rs.getInt(2));
                    objCliente.setNmcliente(rs.getString(3));
                    objCliente.setCpfcnpj(rs.getString(4));
                    objCliente.setTelefone(rs.getString(5));
                    objCliente.setEndereco(rs.getString(6));
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
            stmt = con.prepareStatement("INSERT INTO cliente (nmcliente, cpf_cnpj, telefome, endereco, dtnasc)VALUES(?,?,?,?,?)");
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
            stmt = con.prepareStatement("UPDATE alunos SET nome=?, cod_curso=?, email=?, cod_curso=?, dat_nasc=? WHERE mat_alu=?");
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
}