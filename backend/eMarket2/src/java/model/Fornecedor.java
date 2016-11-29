package model;

/**
 *
 * @author Bárbara
 */
public class Fornecedor {

    private int id;

    private String status;
    private String responsavel;
    private int IE;
    private String IM;
    private String representante;

    private int pessoaId;

    public Fornecedor(String status, int IE, String IM, String representante) {
        this.status = status;
        this.IE = IE;
        this.IM = IM;
        this.representante = representante;
    }

    public Fornecedor(int id, String status, String responsavel, int IE, String IM, String representante, int pessoaId) {
        this.id = id;
        this.status = status;
        this.responsavel = responsavel;
        this.IE = IE;
        this.IM = IM;
        this.representante = representante;
        this.pessoaId = pessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", status=" + status + ", responsavel=" + responsavel + ", IE=" + IE + ", IM=" + IM + ", representante=" + representante + ", pessoaId=" + pessoaId + '}';
    }

}
