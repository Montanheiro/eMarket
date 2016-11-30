package model;

/**
 *
 * @author Bárbara
 */
public class Pessoa {
    
    private int id;

    private String cpf_cnpj;
    private String nome;  
    
    private Contato contato;//Associacao
    private Endereco endereco;//Associacao

    public Pessoa(String cpf_cnpj, String nome, Contato contato, Endereco endereco) {
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
    }

    public Pessoa(int id, String cpf_cnpj, String nome, Contato contato, Endereco endereco) {
        this.id = id;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.contato.setPessoaId(id);
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", cpf_cnpj=" + cpf_cnpj + ", nome=" + nome + ", contato=" + contato + ", endereco=" + endereco + '}';
    }

    
}
