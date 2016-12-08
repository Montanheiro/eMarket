package model;

/**
 *
 * @author Bárbara
 */
public class CompraFormaPagamento {
    
    private int id;
    
    private int compraId;
    private int formaPagamentoId;

    public CompraFormaPagamento() {
    }

    public CompraFormaPagamento(int id, int compraId, int formaPagamentoId) {
        this.id = id;
        this.compraId = compraId;
        this.formaPagamentoId = formaPagamentoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(int formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    @Override
    public String toString() {
        return "CompraFormaPagamento{" + "id=" + id + ", compraId=" + compraId + ", formaPagamentoId=" + formaPagamentoId + '}';
    }
    
}
