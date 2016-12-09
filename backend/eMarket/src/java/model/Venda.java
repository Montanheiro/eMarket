package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class Venda {
    
    private int id;

    private Date dataVenda;
    private double valorTotal;
    
    private int empresaId;
    private int usuarioId;

    public Venda() {
    }

    public Venda(Date dataVenda, double valorTotal) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Venda(int id, Date dataVenda, double valorTotal, int empresaId, int usuarioId) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.empresaId = empresaId;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + '}';
    }
    
    
}
