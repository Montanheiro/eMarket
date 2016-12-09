package model;

/**
 *
 * @author Bárbara
 */
public class Usuario {
    
    private int id;

    private String login;
    private String senha;
    private String tokenSession;
    
    private int funcionarioId;
    private int statusId;

    //private Compra compra;//Associacao

    public Usuario() {
    }

    public Usuario(String login, String senha, String tokenSession) {
        this.login = login;
        this.senha = senha;
        this.tokenSession = tokenSession;
    }

    public Usuario(int id, String login, String senha, String tokenSession, int funcionarioId, int statusId) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tokenSession = tokenSession;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", tokenSession=" + tokenSession + ", funcionarioId=" + funcionarioId + ", statusId=" + statusId + '}';
    }

    
}
