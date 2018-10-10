/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import models.Aluno;
import connection.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//import sun.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import models.Usuario;

/**
 *
 * @author Janquiel Kappler
 */
public class AlunoController {
    
    Aluno objAluno;  
    JTable jTableAlunos = null;
    
    public AlunoController(Aluno objAluno, JTable jTableAlunos) {
        this.objAluno = objAluno;
        this.jTableAlunos = jTableAlunos;
    }
    
    public void PreencheAlunos() {
        
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Matricula");
        cabecalhos.add("Curso");
        cabecalhos.add("Nome");
        
        ResultSet result = null;
        
        try{
            
            String SQL = "";
            SQL = " SELECT a.mat_alu, c.nom_curso, a.nom_alu ";
            SQL += " FROM alunos a, cursos c ";
            SQL += " WHERE a.cod_curso = c.cod_curso ";
            SQL += " ORDER BY nom_alu ";
            
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
        
        jTableAlunos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            //Não permite edição no jTable
        });
        
        //Permite seleção de apenas uma linha da tabela
        jTableAlunos.setSelectionMode(0);
        
        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jTableAlunos.getColumnModel().getColumn(i);
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
            }
        }
        
        jTableAlunos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
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
    
    public Aluno buscarAlunos(String id){
        
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT mat_alu, nom_alu, email, cod_curso, dat_nasc";
            SQL += " FROM alunos";
            SQL += " WHERE mat_alu = '" + id + "'";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar aluno");
                
               objAluno = new Aluno();
               
                if(rs.next() == true)
                {
                    objAluno.setMat_aluno(rs.getInt(1));
                    objAluno.setNom_aluno(rs.getString(2));
                    objAluno.setEmail(rs.getString(3));
                    objAluno.setCod_curso(rs.getInt(4));
                    objAluno.setDat_nasc(String.valueOf(rs.getDate(5)));
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
        return objAluno;
    }
    
    public boolean incluirAluno(Aluno objAluno){      
        
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO alunos (mat_alu, cod_curso, nom_alu, email, dat_nasc)VALUES(?,?,?,?,?)");
            stmt.setInt(1, objAluno.getMat_aluno());
            stmt.setInt(2, objAluno.getCod_curso());
            stmt.setString(3, objAluno.getNom_aluno());
            stmt.setString(4, objAluno.getEmail());
            stmt.setDate(5, Date.valueOf(objAluno.getDat_nasc()));
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean alterarAluno(){
 
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE alunos SET nome=?, cod_curso=?, email=?, cod_curso=?, dat_nasc=? WHERE mat_alu=?");
            stmt.setString(1, objAluno.getNom_aluno());
            stmt.setInt(2, objAluno.getCod_curso());
            stmt.setString(3, objAluno.getEmail());
            stmt.setInt(4, objAluno.getCod_curso());
            stmt.setDate(5, Date.valueOf(objAluno.getDat_nasc()));
            
 
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