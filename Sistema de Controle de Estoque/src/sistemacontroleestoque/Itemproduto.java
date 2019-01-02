/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontroleestoque;

/**
 *
 * @author usuario
 */
public class Itemproduto {
    private int id;
    private float valorvenda;
    private int quantidade;
    private Venda venda;
    private Produto produto;
    
    public Itemproduto(){
    }
    
    public Itemproduto(float valorvenda, int quantidade, Venda venda, Produto produto) {
        this.valorvenda = valorvenda;
        this.quantidade = quantidade;
        this.venda = venda;
        this.produto = produto;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(float valorvenda) {
        this.valorvenda = valorvenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }   
}