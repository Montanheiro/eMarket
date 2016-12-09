package model;

import java.util.ArrayList;

/**
 *
 * @author Bárbara
 */
public class Pessoa {
    
    private int id;

    private String cpf_cnpj;
    private String nome; 
 
    private ArrayList<Contato> contato = new ArrayList<>();//Associacao
    private Endereco endereco;//Associacao

    public Pessoa() {
    }
    
    public Pessoa(String cpf_cnpj, String nome) {
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
    }

    public Pessoa(String cpf_cnpj, String nome, Endereco endereco) {
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Pessoa(int id, String cpf_cnpj, String nome, Endereco endereco) {
        this.id = id;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public Pessoa(int id, String cpf_cnpj, String nome, Endereco endereco, ArrayList<Contato> cs) {
        this.id = id;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = cs;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //this.contato.setPessoaId(id);
        this.endereco.setPessoaId(id);
     }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Contato> getContato() {
        return contato;
    }

    public void setContato(ArrayList<Contato> contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", cpf_cnpj=" + cpf_cnpj + ", nome=" + nome + ", contato=" + contato + ", endereco=" + endereco + '}';
    }
    
    
}
