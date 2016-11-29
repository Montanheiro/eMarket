package model;

/**
 *
 * @author Bárbara
 */
public class Endereco {
    
    private int id;

    private String descricao;
    
    private int pessoaId;

    public Endereco(String descricao) {
        this.descricao = descricao;
    }

    public Endereco(int id, String descricao, int pessoaId) {
        this.id = id;
        this.descricao = descricao;
        this.pessoaId = pessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", descricao=" + descricao + ", pessoaId=" + pessoaId + '}';
    }
        
}
