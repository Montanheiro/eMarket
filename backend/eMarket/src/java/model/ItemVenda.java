package model;

/**
 *
 * @author Bárbara
 */
public class ItemVenda {
    
    private int id;

    private double quantidade;
    private double valorVenda;
    private String status;
    
    private int vendaId;
    private int financeiroCaixaId;
    private int produtoId;

    public ItemVenda(double quantidade, double valorVenda, String status) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.status = status;
    }

    public ItemVenda(int id, double quantidade, double valorVenda, String status, int vendaId, int financeiroCaixaId, int produtoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.status = status;
        this.vendaId = vendaId;
        this.financeiroCaixaId = financeiroCaixaId;
        this.produtoId = produtoId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ", quantidade=" + quantidade + ", valorVenda=" + valorVenda + ", status=" + status + ", vendaId=" + vendaId + ", financeiroCaixaId=" + financeiroCaixaId + ", produtoId=" + produtoId + '}';
    }
    
}
