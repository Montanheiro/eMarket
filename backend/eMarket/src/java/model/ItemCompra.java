package model;

/**
 *
 * @author Bárbara
 */
public class ItemCompra {

    private int id;

    private double quantidade;
    private double valorCompra;
    private String dataCompra;
    private String status;

    private int compraId;
    private int produtoId;

    public ItemCompra(double quantidade, double valorCompra, String dataCompra, String status) {
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
        this.dataCompra = dataCompra;
        this.status = status;
    }

    public ItemCompra(int id, double quantidade, double valorCompra, String dataCompra, String status, int compraId, int produtoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
        this.dataCompra = dataCompra;
        this.status = status;
        this.compraId = compraId;
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

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public String toString() {
        return "ItemCompra{" + "id=" + id + ", quantidade=" + quantidade + ", valorCompra=" + valorCompra + ", dataCompra=" + dataCompra + ", status=" + status + ", compraId=" + compraId + ", produtoId=" + produtoId + '}';
    }

}
