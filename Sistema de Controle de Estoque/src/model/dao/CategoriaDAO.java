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
import sistemacontroleestoque.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class CategoriaDAO {
    
    private Connection con = null;
    
    public CategoriaDAO()
    {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Categoria categoria)
    {
        String sql = "insert into categoria(descricao) values (?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
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
    
    public List<Categoria> Select()
    {
        String sql = "SELECT * FROM categoria;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Categoria categoria = new Categoria();
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
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
        
        return categorias;
    }
    
    public boolean update(Categoria categoria)
    {
        String sql = "UPDATE categoria SET descricao = ? where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.setInt(2, categoria.getId());
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
    
    public boolean delete(Categoria categoria)
    {
        String sql = "DELETE FROM categoria where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoria.getId());
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
