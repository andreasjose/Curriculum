/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import sistemacontroleestoque.Categoria;
import sistemacontroleestoque.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author usuario
 */
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }
    
    @Test
    @Ignore
    public void inserir()
    {
        Categoria cat = new Categoria();
        cat.setId(1);
        
        Produto pro = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        pro.setQtd(200);
        pro.setValor(150.00);
        pro.setDescricao("Vestido");
        pro.setCategoria(cat);
        
        
        if(dao.save(pro))
        {
            System.out.println("Salvo com sucesso");
        }
        else
        {
            fail("Erro ao Salvar");
        }
    }
    @Test
    @Ignore
    public void atualizar()
    {
        Categoria cat = new Categoria();
        cat.setId(1);
        
        Produto pro = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        pro.setQtd(200);
        pro.setValor(150.00);
        pro.setDescricao("Vestido Rosa");
        pro.setCategoria(cat);
        
        pro.setId(1);
        
        if(dao.update(pro))
        {
            System.out.println("Salvo com sucesso");
        }
        else
        {
            fail("Erro ao Salvar");
        }
    }
    
    @Test
    @Ignore
    public void listar()
    {
        ProdutoDAO dao = new ProdutoDAO();
        
        for(Produto p : dao.Select())
        {
            System.out.println("Produto: " + p.getDescricao() + " Quantidade: " + p.getQtd() + " Valor: " + p.getValor() + " Categoria: " + p.getCategoria().getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void delete()
    {
        
        Produto pro = new Produto();
        pro.setId(1);
        ProdutoDAO dao = new ProdutoDAO();
        
        if(dao.delete(pro))
        {
            System.out.println("Deletado com sucesso");
        }
        else
        {
            fail("Erro ao Deletar");
        }
    }
}
