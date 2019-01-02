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
import sistemacontroleestoque.Descricaoproduto;
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
        String sql = "insert into produto(descricaoproduto_id, quantidadeestoque, quantidadecomprada,"
                + "precocompra, precovenda, datavalidade, categoria_id) values (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getDescricao().getId());
            stmt.setInt(2, produto.getQuantidadeestoque());
            stmt.setInt(3, produto.getQuantidadecomprada());
            stmt.setFloat(4, produto.getPrecocompra());
            stmt.setFloat(5, produto.getPrecovenda());
            stmt.setString(6, produto.getDatavalidade());
            stmt.setInt(7, produto.getCategoria().getId());
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
        String sql = "update produto set descricaoproduto_id = ?, categoria_id = ?, \n" +
        "quantidadeestoque = ?, quantidadecomprada = ?, precocompra = ?,\n" +
        "precovenda = ?, datavalidade = ? where id = ?;";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getDescricao().getId());
            stmt.setInt(2, produto.getCategoria().getId());
            stmt.setInt(3, produto.getQuantidadeestoque());
            stmt.setInt(4, produto.getQuantidadecomprada());
            stmt.setFloat(5, produto.getPrecocompra());
            stmt.setFloat(6, produto.getPrecovenda());
            stmt.setString(7, produto.getDatavalidade());
            stmt.setInt(8, produto.getId());
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
        String sql = "select p.id as pid, p.quantidadecomprada, p.quantidadeestoque, p.precocompra,\n" +
        "p.precovenda, p.categoria_id, p.descricaoproduto_id ,c.id as cid, c.descricao \n" +
        "as cdescricao, p.datavalidade, d.id as did, d.descricao as ddescricao \n" +
        "from produto p \n" +
        "inner join categoria c on p.categoria_id = c.id\n" +
        "inner join descricaoproduto d on p.descricaoproduto_id= d.id;";
        
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
                produto.setQuantidadecomprada(rs.getInt("quantidadecomprada"));
                produto.setQuantidadeestoque(rs.getInt("quantidadeestoque"));
                produto.setPrecocompra(rs.getFloat("precocompra"));
                produto.setPrecovenda(rs.getFloat("precovenda"));
                produto.setDatavalidade(rs.getString("datavalidade"));
                
                Descricaoproduto desc = new Descricaoproduto();
                desc.setId(rs.getInt("did"));
                desc.setDescricao(rs.getString("ddescricao"));
                
                produto.setDescricao(desc);
                
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
    
    /*public boolean delete(Produto produto)
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
    }*/
    
    
}
