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
import sistemacontroleestoque.Categoria;
import sistemacontroleestoque.Produto;

/**
 *
 * @author usuario
 */
public class ProdutoDAO {
    
    private Connection con = null;
    
    public ProdutoDAO()
    {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Produto produto)
    {
        String sql = "insert into produto(descricao, categoria_id, qtd, valor) values (?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getCategoria().getId());
            stmt.setInt(3, produto.getQtd());
            stmt.setDouble(4, produto.getValor());
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
    
    public boolean update(Produto produto)
    {
        String sql = "update produto set descricao = ?, categoria_id = ?, qtd = ?, valor = ? where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getCategoria().getId());
            stmt.setInt(3, produto.getQtd());
            stmt.setDouble(4, produto.getValor());
            stmt.setInt(5, produto.getId());
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
    
    public List<Produto> Select()
    {
        String sql = "select p.id as pid, p.descricao as pdescricao, p.qtd, p.valor, p.categoria_id, c.id as cid, c.descricao as cdescricao from produto p inner join categoria c on p.categoria_id = c.id;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Produto produto = new Produto();
                produto.setId(rs.getInt("pid"));
                produto.setDescricao(rs.getString("pdescricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setValor(rs.getInt("valor"));
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("cid"));
                categoria.setDescricao(rs.getString("cdescricao"));
                
                produto.setCategoria(categoria);
                
                produtos.add(produto);
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
        
        return produtos;
    }
    
    public boolean delete(Produto produto)
    {
        String sql = "DELETE FROM produto where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
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
    
    
}
