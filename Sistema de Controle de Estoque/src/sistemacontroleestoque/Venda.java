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
public class Venda {
    private int id;
    private String nomecliente;
    private String cpfcliente;
    private float valortotal;
    private String data;
    private Funcionario funcionario;

    public Venda(String nomecliente, String cpfcliente, float valortotal, String data, Funcionario funcionario) {
        this.nomecliente = nomecliente;
        this.cpfcliente = cpfcliente;
        this.valortotal = valortotal;
        this.data = data;
        this.funcionario = funcionario;
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
