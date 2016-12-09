package model;

import java.sql.Date;

/**
 *
 * @author Bárbara, Mateus
 */
public class Empresa {
    
    private int id;

    private String nome;
    private String razaoSocial;
    private String cnpj;
    private Date dataContratacao;
    private Date dataCancelamentoContrato;
    
    private int statusId;
    
    
    //private Compra compra;//Associacao

    public Empresa() {
    }

    public Empresa(String nome, String razaoSocial, String cnpj, Date dataContratacao, Date dataCancelamentoContrato) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.dataCancelamentoContrato = dataCancelamentoContrato;
    }

    public Empresa(int id, String nome, String razaoSocial, String cnpj, Date dataContratacao, Date dataCancelamentoContrato, int statusId) {
        this.id = id;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.dataCancelamentoContrato = dataCancelamentoContrato;
        this.statusId = statusId;
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

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Date getDataCancelamentoContrato() {
        return dataCancelamentoContrato;
    }

    public void setDataCancelamentoContrato(Date dataCancelamentoContrato) {
        this.dataCancelamentoContrato = dataCancelamentoContrato;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nome=" + nome + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataContratacao=" + dataContratacao + ", dataCancelamentoContrato=" + dataCancelamentoContrato + ", statusId=" + statusId + '}';
    }
    
}
