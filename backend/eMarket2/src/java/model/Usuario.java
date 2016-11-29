package model;

/**
 *
 * @author Bárbara
 */
public class Usuario {
    
    private int id;

    private String login;
    private String senha;
    private String status;
    private String tokenSession;
    
    private int funcionarioId;

    public Usuario(String login, String senha, String status, String tokenSession) {
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tokenSession = tokenSession;
    }

    public Usuario(int id, String login, String senha, String status, String tokenSession, int funcionarioId) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tokenSession = tokenSession;
        this.funcionarioId = funcionarioId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", status=" + status + ", tokenSession=" + tokenSession + ", funcionarioId=" + funcionarioId + '}';
    }
    
    
    
}
