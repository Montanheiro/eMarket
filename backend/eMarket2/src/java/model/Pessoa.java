package model;

/**
 *
 * @author Bárbara
 */
public class Pessoa {
    
    private int id;

    private String cpfCNPJ;
    private String nome;    

    public Pessoa(String cpfCNPJ, String nome) {
        this.cpfCNPJ = cpfCNPJ;
        this.nome = nome;
    }

    public Pessoa(int id, String cpfCNPJ, String nome) {
        this.id = id;
        this.cpfCNPJ = cpfCNPJ;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", cpfCNPJ=" + cpfCNPJ + ", nome=" + nome + '}';
    }
    
}
