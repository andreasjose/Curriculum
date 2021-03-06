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
import sistemacontroleestoque.Descricaoproduto;

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
        cat.setId(5);
        
        Descricaoproduto desc = new Descricaoproduto();
        desc.setId(12);
        
        Produto pro = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        pro.setQuantidadeestoque(200);
        pro.setQuantidadecomprada(200);
        pro.setPrecocompra((float) 7.5);
        pro.setPrecovenda((float) 8.5);
        pro.setDatavalidade("2019-04-10");
        
        pro.setDescricao(desc);
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
        cat.setId(5);
        
        Descricaoproduto desc = new Descricaoproduto();
        desc.setId(12);
        
        Produto pro = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        pro.setQuantidadeestoque(200);
        pro.setQuantidadecomprada(200);
        pro.setPrecocompra((float) 7.5);
        pro.setPrecovenda((float) 8.5);
        pro.setDatavalidade("2019-04-10");
        
        pro.setDescricao(desc);
        pro.setCategoria(cat);
        pro.setId(16);
        
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
            System.out.println("Produto: " + p.getDescricao().getDescricao()+ " Quantidade Estoque: " + p.getQuantidadeestoque()+ 
                    " Quantidade Comprada: " + p.getQuantidadecomprada() + " Valor de Compra: " + p.getPrecocompra()+
                    " Valor de Venda: "+ p.getPrecovenda()+" Categoria: " + p.getCategoria().getDescricao());
        }
    }
    
    
    @Test
    @Ignore
    public void delete()
    {
        
        Produto pro = new Produto();
        pro.setId(14);
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
