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
import sistemacontroleestoque.Itemproduto;
import sistemacontroleestoque.Produto;
import sistemacontroleestoque.Venda;

/**
 *
 * @author usuario
 */
public class ItemprodutoDAO {
    
    private Connection con = null;
    
    public ItemprodutoDAO()
    {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Itemproduto itemproduto)
    {
        String sql = "insert into itemproduto(valorvenda, quantidade,"
        + "venda_id, produto_id) values (?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setFloat(1, itemproduto.getValorvenda());
            stmt.setInt(2, itemproduto.getQuantidade());
            stmt.setInt(3, itemproduto.getVenda().getId());
            stmt.setInt(4, itemproduto.getProduto().getId());
            stmt.executeUpdate();
            return true;
        }
        
        catch (SQLException ex)
        {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt);
        }   
    }
    
    public boolean update(Itemproduto itemproduto)
    {
        String sql = "update itemproduto set valorvenda = ?, quantidade = ?,"
        + "venda_id = ?, produto_id = ? where id = ?;";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setFloat(1, itemproduto.getValorvenda());
            stmt.setInt(2, itemproduto.getQuantidade());
            stmt.setInt(3, itemproduto.getVenda().getId());
            stmt.setInt(4, itemproduto.getProduto().getId());
            
            stmt.setInt(5, itemproduto.getId());
            stmt.executeUpdate();
            return true;
        }
        
        catch (SQLException ex)
        {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt);
        }   
    }
    
    public List<Itemproduto> Select()
    {
        String sql = "select * from itemproduto i;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Itemproduto> itemprodutos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Itemproduto itemproduto = new Itemproduto();
                itemproduto.setId(rs.getInt("id"));
                itemproduto.setQuantidade(rs.getInt("quantidade"));
                itemproduto.setValorvenda(rs.getFloat("valorvenda"));
                
                Produto pro = new Produto();
                pro.setId(rs.getInt("produto_id"));
                
                itemproduto.setProduto(pro);
                
                Venda ven = new Venda();
                ven.setId(rs.getInt("venda_id"));
                
                itemproduto.setVenda(ven);
                
                itemprodutos.add(itemproduto);
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
        
        return itemprodutos;
    }

    public boolean delete(Itemproduto item)
    {
        String sql = "DELETE FROM itemproduto where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getId());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ItemprodutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            ConnectionFactory.closeconnection(con, stmt);
        }   
    }
}