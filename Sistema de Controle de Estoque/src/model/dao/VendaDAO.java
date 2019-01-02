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
import sistemacontroleestoque.Venda;

/**
 *
 * @author usuario
 */
public class VendaDAO {
    
    private Connection con = null;
    
    public VendaDAO()
    {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Venda venda)
    {
        String sql = "insert into venda(nomecliente, cpfcliente,"
        + "valortotal, data, funcionario_id) values (?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, venda.getNomecliente());
            stmt.setString(2, venda.getCpfcliente());
            stmt.setFloat(3, venda.getValortotal());
            stmt.setString(4, venda.getData());
            stmt.setInt(5, venda.getFuncionario().getId());
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
    
    public boolean update(Venda venda)
    {
        String sql = "update venda set nomecliente = ?, cpfcliente = ?, \n" +
        "valortotal = ?, data = ?, funcionario_id = ? where id = ?;";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, venda.getNomecliente());
            stmt.setString(2, venda.getCpfcliente());
            stmt.setFloat(3, venda.getValortotal());
            stmt.setString(4, venda.getData());
            stmt.setInt(5, venda.getFuncionario().getId());
            stmt.setInt(6, venda.getId());
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
    
    public List<Venda> Select()
    {
        String sql = "select v.*, f.nome from venda v\n" +
        "inner join funcionario f on f.id = v.funcionario_id;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Venda> vendas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setNomecliente(rs.getString("nomecliente"));
                venda.setCpfcliente(rs.getString("cpfcliente"));
                venda.setValortotal(rs.getFloat("valortotal"));
                venda.setData(rs.getString("data"));
                
                Funcionario fun = new Funcionario();
                fun.setId(rs.getInt("funcionario_id"));
                fun.setNome(rs.getString("nome"));
                
                venda.setFuncionario(fun);
                
                vendas.add(venda);
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
        
        return vendas;
    }
    
    public boolean delete(Venda venda)
    {
        String sql = "DELETE FROM venda where id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda.getId());
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
