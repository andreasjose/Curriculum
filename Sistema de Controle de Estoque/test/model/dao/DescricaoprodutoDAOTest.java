/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import sistemacontroleestoque.Descricaoproduto;

/**
 *
 * @author usuario
 */
public class DescricaoprodutoDAOTest {
    
    public DescricaoprodutoDAOTest() {
    }

    @Test
    @Ignore
    public void inserir()
    {
        
        Descricaoproduto desc = new Descricaoproduto("Roupas");
        DescricaoprodutoDAO dao = new DescricaoprodutoDAO();
        
        if(dao.save(desc))
        {
            System.out.println("Salvo com sucesso");
        }
        else
        {
            fail("Erro ao Salvar");
        }
    }
    
    @Test
    //@Ignore
    public void listar()
    {
        DescricaoprodutoDAO dao = new DescricaoprodutoDAO();
        
        for(Descricaoproduto c : dao.Select())
        {
            System.out.println("ID: "+ c.getId() +" Descrição: " + c.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void atualizar()
    {
        
        Descricaoproduto desc = new Descricaoproduto("Roupa");
        desc.setId(15);
        DescricaoprodutoDAO dao = new DescricaoprodutoDAO();
        
        if(dao.update(desc))
        {
            System.out.println("Atualizado com sucesso");
        }
        else
        {
            fail("Erro ao Atualizar");
        }
    }
    
    @Test
    @Ignore
    public void delete()
    {
        
        Descricaoproduto desc = new Descricaoproduto("Roupa");
        desc.setId(15);
        DescricaoprodutoDAO dao = new DescricaoprodutoDAO();
        
        if(dao.delete(desc))
        {
            System.out.println("Deletado com sucesso");
        }
        else
        {
            fail("Erro ao Deletar");
        }
    }
}
