package model;

import java.sql.Date;

/**
 *
 * @author Bárbara,Mateus
 */
public class Empresa {
    
    private int id;

    private String Nome;
    private String RazaoSocial;
    private String CNPJ;
    private Date DataContratacao;
    private Date DataCancelamentoContrato;
    private int Status;
    
    
    //private Compra compra;//Associacao
    

    public Empresa(String nome, String razaoSocial, String cnpj, Date dataContratacao, Date dataCancelamentoContrato, int status /*, Compra compra*/) {
        this.Nome = nome;
        this.RazaoSocial = razaoSocial;
        this.CNPJ = cnpj;
        this.DataContratacao = dataContratacao;
        this.DataCancelamentoContrato = dataCancelamentoContrato;
        this.Status = status;
       // this.compra = compra;
    }

    public Empresa(int id, String nome, String razaoSocial, String cnpj, Date dataContratacao, Date dataCancelamentoContrato, int status/*, Compra compra*/) {
        this.id = id;
        this.Nome = nome;
        this.RazaoSocial = razaoSocial;
        this.CNPJ = cnpj;
        this.DataContratacao = dataContratacao;
        this.DataCancelamentoContrato = dataCancelamentoContrato;
        this.Status = status;
       // this.compra = compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.RazaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return CNPJ;
    }

    public void setCnpj(String cnpj) {
        this.CNPJ = cnpj;
    }

    public Date getDataContratacao() {
        return DataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.DataContratacao = dataContratacao;
    }
    
    public Date getDataCancelamentoContrato(){
        return DataCancelamentoContrato;
    }
    public void setDataCancelamentoContrato(Date dataCancelamentoContrato){
        this.DataCancelamentoContrato = dataCancelamentoContrato;
    }
    
    public int getStatus(){
        return Status;
    }
    public void setStatus(int status) {
    this.Status = status;
}

//    public Compra getCompra() {
//        return compra;
//    }

//    public void setCompra(Compra compra) {
//        this.compra = compra;
//    }
    
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nome=" + Nome + ", razaoSocial=" + RazaoSocial + ", cnpj=" + CNPJ + ", dataContratacao=" + DataContratacao +", dataCancelamentoContrato="+DataCancelamentoContrato+", status="+Status+ '}';
    }
    
}
