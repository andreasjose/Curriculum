/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import sistemacontroleestoque.Funcionario;
import sistemacontroleestoque.Venda;

/**
 *
 * @author usuario
 */
public class VendaDAOTest {
    
    public VendaDAOTest() {
    }

    @Test
    @Ignore
    public void inserir()
    {   
        Funcionario fun = new Funcionario();
        fun.setId(6);
        
        Venda ven = new Venda();
        VendaDAO dao = new VendaDAO();
        
        ven.setCpfcliente("14718857716");
        ven.setNomecliente("João");
        ven.setValortotal((float) 20.5);
        ven.setData("2019-04-10");
        
        ven.setFuncionario(fun);
        
        
        if(dao.save(ven))
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
        Funcionario fun = new Funcionario();
        fun.setId(6);
        
        Venda ven = new Venda();
        VendaDAO dao = new VendaDAO();
        
        ven.setCpfcliente("14718857716");
        ven.setNomecliente("João Pereira");
        ven.setValortotal((float) 20.5);
        ven.setData("2019-04-11");
        
        ven.setFuncionario(fun);
        
        ven.setId(1);
        
        
        if(dao.update(ven))
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
    public void listar()
    {
        VendaDAO dao = new VendaDAO();
        
        for(Venda v : dao.Select())
        {
            System.out.println("ID Venda: " + v.getId()+ " Nome do cliente: " + v.getNomecliente()+ 
                    " CPF do Cliente: " + v.getCpfcliente()+ " Data da venda: " + v.getData()+
                    " Valor total da Venda: "+ v.getValortotal()+" Vendedor: " + v.getFuncionario().getNome()
                    + " ID do funcionario: " + v.getFuncionario().getId());
        }
    }
    
    @Test
    @Ignore
    public void delete()
    {
        
        Venda ven = new Venda();
        ven.setId(1);
        VendaDAO dao = new VendaDAO();
        
        if(dao.delete(ven))
        {
            System.out.println("Deletado com sucesso");
        }
        else
        {
            fail("Erro ao Deletar");
        }
    }
}
