package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class ItemCompra {

    private int id;

    private double quantidade;
    private double valorCompra;
    private String dataCompra;

    private int compraId;
    private int produtoId;
    private int statusId;

    public ItemCompra() {
    }

    public ItemCompra(double quantidade, double valorCompra, String dataCompra) {
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
        this.dataCompra = dataCompra;
    }

    public ItemCompra(int id, double quantidade, double valorCompra, String dataCompra, int compraId, int produtoId, int statusId) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
        this.dataCompra = dataCompra;
        this.compraId = compraId;
        this.produtoId = produtoId;
        this.statusId = statusId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "ItemCompra{" + "id=" + id + ", quantidade=" + quantidade + ", valorCompra=" + valorCompra + ", dataCompra=" + dataCompra + ", compraId=" + compraId + ", produtoId=" + produtoId + ", statusId=" + statusId + '}';
    }


}
