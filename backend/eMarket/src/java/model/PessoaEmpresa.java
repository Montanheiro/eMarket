package model;

/**
 *
 * @author Bárbara
 */
public class PessoaEmpresa {
    
    private int id;
    
    private Pessoa pessoa;
    private Empresa empresa;
    
    private int empresaId;
    private int pessoaId;

    public PessoaEmpresa() {
    }

    public PessoaEmpresa(int empresaId, int pessoaId) {
        this.empresaId = empresaId;
        this.pessoaId = pessoaId;
    }

    public PessoaEmpresa(int id, int empresaId, int pessoaId) {
        this.id = id;
        this.empresaId = empresaId;
        this.pessoaId = pessoaId;
    }

    public PessoaEmpresa(int id, Pessoa pessoa, Empresa empresa) {
        this.id = id;
        this.pessoa = pessoa;
        this.empresa = empresa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa Empresa) {
        this.empresa = Empresa;
    }

    @Override
    public String toString() {
        return "PessoaEmpresa{" + "id=" + id + ", pessoa=" + pessoa + ", Empresa=" + empresa + ", empresaId=" + empresaId + ", pessoaId=" + pessoaId + '}';
    }
    
}
