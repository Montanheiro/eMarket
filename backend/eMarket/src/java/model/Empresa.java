package model;

/**
 *
 * @author Bárbara, Mateus
 */
public class Empresa {
    
    private int id;

    private String nome;
    private String razaoSocial;
    private String cnpj;
    private String dataContratacao;
    private String dataCancelamentoContrato;
    
    private Status status;
    
    private int statusId;
    
    
    //private Compra compra;//Associacao

    public Empresa() {
    }

    public Empresa(String nome, String razaoSocial, String cnpj, String dataContratacao, String dataCancelamentoContrato) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.dataCancelamentoContrato = dataCancelamentoContrato;
    }

    public Empresa(int id, String nome, String razaoSocial, String cnpj, String dataContratacao, String dataCancelamentoContrato, int statusId) {
        this.id = id;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.dataCancelamentoContrato = dataCancelamentoContrato;
        this.statusId = statusId;
    }

    public Empresa(int id, String nome, String razaoSocial, String cnpj, String dataContratacao, String dataCancelamentoContrato, Status status) {
        this.id = id;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.dataCancelamentoContrato = dataCancelamentoContrato;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getDataCancelamentoContrato() {
        return dataCancelamentoContrato;
    }

    public void setDataCancelamentoContrato(String dataCancelamentoContrato) {
        this.dataCancelamentoContrato = dataCancelamentoContrato;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nome=" + nome + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataContratacao=" + dataContratacao + ", dataCancelamentoContrato=" + dataCancelamentoContrato + ", statusId=" + statusId + '}';
    }
    
}
