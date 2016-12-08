package model;

/**
 *
 * @author Bárbara
 */
public class PessoaEmpresa {
    
    private int id;
    private int empresaId;
    private int pessoaId;

    public PessoaEmpresa() {
    }

    public PessoaEmpresa(int id, int empresaId, int pessoaId) {
        this.id = id;
        this.empresaId = empresaId;
        this.pessoaId = pessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "PessoaEmpresa{" + "id=" + id + ", empresaId=" + empresaId + ", pessoaId=" + pessoaId + '}';
    }
    
}
