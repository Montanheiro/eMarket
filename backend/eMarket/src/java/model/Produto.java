package model;

/**
 *
 * @author Bárbara
 */
public class Produto {
    
    private int id;

    private int codBarras;
    private String nome;    
    private String descricao;
    private String margem;
    private String ncm;
    private double valorUnitario;
    private String dataVencimento;
    
    private int empresaId;
    
    private Promocao promocao;
    private Empresa empresa;

    public Produto() {
    }

    public Produto(int codBarras, String nome, String descricao, String margem, String ncm, double valorUnitario, String dataVencimento) {
        this.codBarras = codBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.margem = margem;
        this.ncm = ncm;
        this.valorUnitario = valorUnitario;
        this.dataVencimento = dataVencimento;
    }

    public Produto(int id, int codBarras, String nome, String descricao, String margem, String ncm, double valorUnitario, String dataVencimento, Empresa empresa, Promocao promocao) {
        this.id = id;
        this.codBarras = codBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.margem = margem;
        this.ncm = ncm;
        this.valorUnitario = valorUnitario;
        this.dataVencimento = dataVencimento;
        this.empresa = empresa;
        this.promocao = promocao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMargem() {
        return margem;
    }

    public void setMargem(String margem) {
        this.margem = margem;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", codBarras=" + codBarras + ", nome=" + nome + ", descricao=" + descricao + ", margem=" + margem + ", ncm=" + ncm + ", valorUnitario=" + valorUnitario + ", dataVencimento=" + dataVencimento + ", empresaId=" + empresaId + ", promocao=" + promocao + ", empresa=" + empresa + '}';
    }

}
