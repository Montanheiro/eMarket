package model;

/**
 *
 * @author Bárbara
 */
public class Fornecedor {
    
    private int id;
    
    private String responsavel;
    private int IE;
    private String IM;
    private String representante;
    
    private Pessoa pessoa;
    private Status status;

    private int pessoaId;
    private int statusId;

    public Fornecedor() {
    }

    public Fornecedor(String responsavel, int IE, String IM, String representante) {
        this.responsavel = responsavel;
        this.IE = IE;
        this.IM = IM;
        this.representante = representante;
    }

    public Fornecedor(int id, String responsavel, int IE, String IM, String representante, int pessoaId, int statusId) {
        this.id = id;
        this.responsavel = responsavel;
        this.IE = IE;
        this.IM = IM;
        this.representante = representante;
        this.pessoaId = pessoaId;
        this.statusId = statusId;
    }

    public Fornecedor(int id, String responsavel, int IE, String IM, String representante, Pessoa pessoa, Status status) {
        this.id = id;
        this.responsavel = responsavel;
        this.IE = IE;
        this.IM = IM;
        this.representante = representante;
        this.pessoa = pessoa;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getIE() {
        return IE;
    }

    public void setIE(int IE) {
        this.IE = IE;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", responsavel=" + responsavel + ", IE=" + IE + ", IM=" + IM + ", representante=" + representante + ", pessoa=" + pessoa + ", status=" + status + ", pessoaId=" + pessoaId + ", statusId=" + statusId + '}';
    }


}
