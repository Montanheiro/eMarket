package model;

/**
 *
 * @author Bárbara
 */
public class Produto {
    
    private int id;

    private String descricao;
    private String margem;
    private String ncm;
    private String nome;
    private double valorUnitario;
    private String dataVencimento;
    
    private int promocaoId;
    private int empresaId;

    public Produto(String descricao, String margem, String ncm, String nome, double valorUnitario, String dataVencimento) {
        this.descricao = descricao;
        this.margem = margem;
        this.ncm = ncm;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.dataVencimento = dataVencimento;
    }

    public Produto(int id, String descricao, String margem, String ncm, String nome, double valorUnitario, String dataVencimento, int promocaoId, int empresaId) {
        this.id = id;
        this.descricao = descricao;
        this.margem = margem;
        this.ncm = ncm;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.dataVencimento = dataVencimento;
        this.promocaoId = promocaoId;
        this.empresaId = empresaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getPromocaoId() {
        return promocaoId;
    }

    public void setPromocaoId(int promocaoId) {
        this.promocaoId = promocaoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", margem=" + margem + ", ncm=" + ncm + ", nome=" + nome + ", valorUnitario=" + valorUnitario + ", dataVencimento=" + dataVencimento + ", promocaoId=" + promocaoId + ", empresaId=" + empresaId + '}';
    }
    
    

}
