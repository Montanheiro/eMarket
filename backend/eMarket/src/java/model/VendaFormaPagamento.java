package model;

/**
 *
 * @author Bárbara
 */
public class VendaFormaPagamento {
    
    private int id;
    private int vendaId;
    private int formaPagamentoId;

    public VendaFormaPagamento() {
    }

    public VendaFormaPagamento(int vendaId, int formaPagamentoId) {
        this.vendaId = vendaId;
        this.formaPagamentoId = formaPagamentoId;
    }
    
    public VendaFormaPagamento(int id, int vendaId, int formaPagamentoId) {
        this.id = id;
        this.vendaId = vendaId;
        this.formaPagamentoId = formaPagamentoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(int formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    @Override
    public String toString() {
        return "VendaFormaPagamento{" + "id=" + id + ", vendaId=" + vendaId + ", formaPagamentoId=" + formaPagamentoId + '}';
    }
    
}
