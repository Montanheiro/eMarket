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
    private ArrayList<Email> email = new ArrayList<>();//Associacao
    private Endereco endereco;//Associacao

    public Pessoa() {
    }
    
    public Pessoa(int id, String cpf_cnpj, String nome, Endereco endereco, ArrayList<Contato> cs, ArrayList<Email> email) {
        this.id = id;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = cs;
        this.email = email;
    }    

    public Pessoa(String cpf_cnpj, String nome, Endereco endereco, ArrayList<Contato> cs, ArrayList<Email> email) {
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = cs;
        this.email = email;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Email> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<Email> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", cpf_cnpj=" + cpf_cnpj + ", nome=" + nome + ", contato=" + contato + ", email=" + email + ", endereco=" + endereco + '}';
    }
    
}
