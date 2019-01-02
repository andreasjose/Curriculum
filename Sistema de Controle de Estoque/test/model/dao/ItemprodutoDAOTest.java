/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import sistemacontroleestoque.Itemproduto;
import sistemacontroleestoque.Produto;
import sistemacontroleestoque.Venda;

/**
 *
 * @author usuario
 */
public class ItemprodutoDAOTest {
    
    public ItemprodutoDAOTest() {
    }

    @Test
    @Ignore
    public void inserir()
    {   
        Produto pro = new Produto();
        pro.setId(6);
        
        Venda ven = new Venda();
        ven.setId(2);
                
        Itemproduto itemproduto = new Itemproduto();
        ItemprodutoDAO dao = new ItemprodutoDAO();
        
        itemproduto.setQuantidade(10);
        itemproduto.setValorvenda((float)20.5);

        
        itemproduto.setProduto(pro);
        
        itemproduto.setVenda(ven);
        
        
        if(dao.save(itemproduto))
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
        Produto pro = new Produto();
        pro.setId(6);
        
        Venda ven = new Venda();
        ven.setId(2);
                
        Itemproduto itemproduto = new Itemproduto();
        ItemprodutoDAO dao = new ItemprodutoDAO();
        
        itemproduto.setQuantidade(5);
        itemproduto.setValorvenda((float)20);

        
        itemproduto.setProduto(pro);
        
        itemproduto.setVenda(ven);
        
        itemproduto.setId(4);
        
        
        if(dao.update(itemproduto))
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
        ItemprodutoDAO dao = new ItemprodutoDAO();
        
        for(Itemproduto i : dao.Select())
        {
            System.out.println("ID do Item de produto: " + i.getId()+ " Valor da venda: " + i.getValorvenda()+ 
                    " Quantidade vendida: " + i.getQuantidade()+ " ID do produto vendido: " + i.getProduto().getId()+
                    " ID da Venda: "+ i.getVenda().getId());
        }
    }
    
    @Test
    @Ignore
    public void delete()
    {
        
        Itemproduto item = new Itemproduto();
        item.setId(4);
        ItemprodutoDAO dao = new ItemprodutoDAO();
        
        if(dao.delete(item))
        {
            System.out.println("Deletado com sucesso");
        }
        else
        {
            fail("Erro ao Deletar");
        }
    }

    
}
