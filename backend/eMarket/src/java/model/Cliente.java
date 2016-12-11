package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class Cliente {
    
    private int id;
    
    private Date dataNascimento;
    private int rg;
    private double limite;
    
    private Pessoa pessoa;
    
    private int pessoaId;

    public Cliente() {
    }

    public Cliente(Date dataNascimento, int rg, double limite, Pessoa pessoa) {
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.limite = limite;
        this.pessoa = pessoa;
    }

    public Cliente(int id, Date dataNascimento, int rg, double limite, int pessoaId) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.limite = limite;
        this.pessoaId = pessoaId;
    }

    public Cliente(int id, Date dataNascimento, int rg, double limite, Pessoa pessoa) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.limite = limite;
        this.pessoa = pessoa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", dataNascimento=" + dataNascimento + ", rg=" + rg + ", limite=" + limite + ", pessoa=" + pessoa + ", pessoaId=" + pessoaId + '}';
    }
    
    
    
}
