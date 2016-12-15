package model;

/**
 *
 * @author Bárbara
 */
public class ItemVenda {
    
    private int id;

    private double quantidade;
    private double valorVenda;
    
    private Produto produto;
    private FinanceiroCaixa financeiro;
    private Status status;
    
    private int vendaId;
    private int financeiroCaixaId;
    private int produtoId;
    private int statusId;

    public ItemVenda() {
    }

    public ItemVenda(double quantidade, double valorVenda) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
    }

    public ItemVenda(int id, double quantidade, double valorVenda, int vendaId, int financeiroCaixaId, int produtoId, int statusId) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.vendaId = vendaId;
        this.financeiroCaixaId = financeiroCaixaId;
        this.produtoId = produtoId;
        this.statusId = statusId;
    }

    public ItemVenda(int id, double quantidade, double valorVenda, Produto produto, FinanceiroCaixa financeiro, Status status, int vendaId) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.produto = produto;
        this.financeiro = financeiro;
        this.status = status;
        this.vendaId = vendaId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getFinanceiroCaixaId() {
        return financeiroCaixaId;
    }

    public void setFinanceiroCaixaId(int financeiroCaixaId) {
        this.financeiroCaixaId = financeiroCaixaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public FinanceiroCaixa getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(FinanceiroCaixa financeiro) {
        this.financeiro = financeiro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ", quantidade=" + quantidade + ", valorVenda=" + valorVenda + ", produto=" + produto + ", financeiro=" + financeiro + ", status=" + status + ", vendaId=" + vendaId + ", financeiroCaixaId=" + financeiroCaixaId + ", produtoId=" + produtoId + ", statusId=" + statusId + '}';
    }
    

    
}
