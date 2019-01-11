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
import sistemacontroleestoque.Descricaoproduto;

/**
 *
 * @author usuario
 */
public class DescricaoprodutoDAO {
 
    private Connection con = null;
    
    public DescricaoprodutoDAO()
    {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Descricaoproduto descricao)
    {
        String sql = "insert into descricaoproduto(descricao) values (?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao.getDescricao());
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
    
    public List<Descricaoproduto> Select()
    {
        String sql = "SELECT * FROM descricaoproduto;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Descricaoproduto> descricaos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Descricaoproduto descricao = new Descricaoproduto();
                descricao.setDescricao(rs.getString("descricao"));
                descricao.setId(rs.getInt("id"));
                descricaos.add(descricao);
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
        
        return descricaos;
    }
    
    public List<Descricaoproduto> Select(int Categoria_id)
    {
        String sql = "SELECT * FROM descricaoproduto where categoria_id = " + Categoria_id +";";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Descricaoproduto> descricaos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Descricaoproduto descricao = new Descricaoproduto();
                descricao.setDescricao(rs.getString("descricao"));
                descricao.setId(rs.getInt("id"));
                descricaos.add(descricao);
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
        
        return descricaos;
    }
    
    public boolean update(Descricaoproduto descricao)
    {
        String sql = "UPDATE descricaoproduto SET descricao = ? where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao.getDescricao());
            stmt.setInt(2, descricao.getId());
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
    
    public boolean delete(Descricaoproduto descricao)
    {
        String sql = "DELETE FROM descricaoproduto where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, descricao.getId());
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
