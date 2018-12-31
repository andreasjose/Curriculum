/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import sistemacontroleestoque.Categoria;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author usuario
 */
public class CategoriaDAOTest {
    
    public CategoriaDAOTest() {
    }

    @Test
    @Ignore
    public void inserir()
    {
        
        Categoria cat = new Categoria("Roupas");
        CategoriaDAO dao = new CategoriaDAO();
        
        if(dao.save(cat))
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
        CategoriaDAO dao = new CategoriaDAO();
        
        for(Categoria c : dao.Select())
        {
            System.out.println("Descrição: " + c.getDescricao());
        }
    }
    
    @Test
    @Ignore
    public void atualizar()
    {
        
        Categoria cat = new Categoria("Roupa");
        cat.setId(1);
        CategoriaDAO dao = new CategoriaDAO();
        
        if(dao.update(cat))
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
        
        Categoria cat = new Categoria("Roupa");
        cat.setId(1);
        CategoriaDAO dao = new CategoriaDAO();
        
        if(dao.delete(cat))
        {
            System.out.println("Deletado com sucesso");
        }
        else
        {
            fail("Erro ao Deletar");
        }
    }
    
}

