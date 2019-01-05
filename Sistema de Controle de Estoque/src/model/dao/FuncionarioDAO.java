/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemacontroleestoque.Funcionario;

/**
 *
 * @author usuario
 */
public class FuncionarioDAO {
    
    private Connection con = null;
    
    public FuncionarioDAO()
    {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Funcionario funcionario)
    {
        String sql = "insert into funcionario(nome, login, senha) values (?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt);
        }   
    }
    
    public List<Funcionario> Select()
    {
        String sql = "SELECT * FROM funcionario;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setId(rs.getInt("id"));
                funcionarios.add(funcionario);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Erro: " + ex);
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public List<Funcionario> Select(String ID)
    {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM funcionario where id = " + ID + ";";
        
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setId(rs.getInt("id"));
                funcionarios.add(funcionario);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Erro: " + ex);
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public boolean update(Funcionario funcionario)
    {
        String sql = "UPDATE funcionario SET nome = ?, login = ?, senha = ? where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt);
        }   
    }
    
    public boolean delete(Funcionario funcionario)
    {
        String sql = "DELETE FROM funcionario where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt);
        }   
    }
}
