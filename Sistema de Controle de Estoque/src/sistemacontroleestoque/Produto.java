/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontroleestoque;

 /*
 *
 * @author Andreas
 */

public class Produto {
    private int id;
    private Descricaoproduto descricao;
    private int quantidadeestoque;
    private int quantidadecomprada;
    private float precovenda;
    private float precocompra;
    private String datavalidade;
    private Categoria categoria;

    public Produto()
    {
    
    }

    public Produto(Descricaoproduto descricao, int quantidadecomprada, float precocompra, float precovenda, Categoria categoria, String datavalidade) {
        this.descricao = descricao;
        this.quantidadeestoque = quantidadecomprada;
        this.quantidadeestoque = quantidadecomprada;
        this.precovenda = precovenda;
        this.precocompra = precocompra;
        this.datavalidade = datavalidade;
        this.categoria = categoria;
    }

    
    public int getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(int quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public int getQuantidadecomprada() {
        return quantidadecomprada;
    }

    public void setQuantidadecomprada(int quantidadecomprada) {
        this.quantidadecomprada = quantidadecomprada;
    }

    public float getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(float precovenda) {
        this.precovenda = precovenda;
    }

    public float getPrecocompra() {
        return precocompra;
    }

    public void setPrecocompra(float precocompra) {
        this.precocompra = precocompra;
    }

    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Descricaoproduto getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricaoproduto descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}

