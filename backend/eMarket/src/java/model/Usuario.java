package model;

/**
 *
 * @author Bárbara
 */
public class Usuario {
    
    private int id;

    private String login;
    private String senha;
    
    private int funcionarioId;
    private int statusId;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String login, String senha, int funcionarioId, int statusId) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.funcionarioId = funcionarioId;
        this.statusId = statusId;
    }
    public Usuario(int id, String login, int funcionarioId, int statusId) {
        this.id = id;
        this.login = login;
        this.funcionarioId = funcionarioId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", funcionarioId=" + funcionarioId + ", statusId=" + statusId + '}';
    }

    
}
