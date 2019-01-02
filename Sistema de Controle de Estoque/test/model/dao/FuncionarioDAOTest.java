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

/**
 *
 * @author usuario
 */
public class FuncionarioDAOTest {
    
    public FuncionarioDAOTest() {
    }

    @Test
    @Ignore
    public void inserir()
    {
        
        Funcionario func = new Funcionario();
        func.setNome("Andreas");
        func.setLogin("Andreasj");
        func.setSenha("123");
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if(dao.save(func))
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
        FuncionarioDAO fun = new FuncionarioDAO();
        
        for(Funcionario f : fun.Select())
        {
            System.out.println("ID: "+ f.getId() +" Nome: " + f.getNome() + " Login: " + f.getLogin() + " Senha: " + f.getSenha());
        }
    }
    
        
    @Test
    @Ignore
    public void atualizar()
    {
        
        Funcionario func = new Funcionario();
        func.setNome("Andreas José");
        func.setLogin("AndreasJo");
        func.setSenha("1234");
        func.setId(6);
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if(dao.update(func))
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
        
        Funcionario func = new Funcionario();
        func.setId(6);
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if(dao.delete(func))
        {
            System.out.println("Deletado com sucesso");
        }
        else
        {
            fail("Erro ao Deletar");
        }
    }
}