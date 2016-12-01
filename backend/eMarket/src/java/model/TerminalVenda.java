package model;

/**
 *
 * @author Bárbara
 */
public class TerminalVenda {
    
    private int id;

    private int numeroMaquina;
    private String token;
    
    private int empresaId;
    private int usuarioId;

    public TerminalVenda(int numeroMaquina, String token) {
        this.numeroMaquina = numeroMaquina;
        this.token = token;
    }

    public TerminalVenda(int id, int numeroMaquina, String token, int empresaId, int usuarioId) {
        this.id = id;
        this.numeroMaquina = numeroMaquina;
        this.token = token;
        this.empresaId = empresaId;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(int numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "TerminalVenda{" + "id=" + id + ", numeroMaquina=" + numeroMaquina + ", token=" + token + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + '}';
    }
    
    
}
