package model;

/**
 *
 * @author Bárbara
 */
public class Email {
    
    private int id;
    
    private String email;
    
    private int pessoaId;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public Email(int id, String email, int pessoaId) {
        this.id = id;
        this.email = email;
        this.pessoaId = pessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Email{" + "id=" + id + ", email=" + email + ", pessoaId=" + pessoaId + '}';
    }
    
    
}
