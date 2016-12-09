package model;

/**
 *
 * @author Bárbara
 */
public class Contato {

    private int id;

    private String telefone;
        
    private int pessoaId;

    public Contato() {
    }
    
    public Contato(String telefone) {
        this.telefone = telefone;
    }

    public Contato(int id, String telefone, int pessoaId) {
        this.id = id;
        this.telefone = telefone;
        this.pessoaId = pessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", telefone=" + telefone + ", pessoaId=" + pessoaId + '}';
    }
    
}
