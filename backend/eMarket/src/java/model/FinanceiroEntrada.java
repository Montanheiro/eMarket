package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class FinanceiroEntrada {
    
    private int id;

    private Date dataVencimento;
    private double valor;
    private int numParcela;
    private Date dataBaixa;
    
    private int movimentacaoFinanceiraId;
    private int formaPagamentoId;
    private int vendaId;
    private int statusId;

    public FinanceiroEntrada() {
    }

    public FinanceiroEntrada(Date dataVencimento, double valor, int numParcela, Date dataBaixa) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.numParcela = numParcela;
        this.dataBaixa = dataBaixa;
    }
    
    public FinanceiroEntrada(int id, Date dataVencimento, double valor, int numParcela, Date dataBaixa, int movimentacaoFinanceiraId, int formaPagamentoId, int vendaId, int statusId) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.numParcela = numParcela;
        this.dataBaixa = dataBaixa;
        this.movimentacaoFinanceiraId = movimentacaoFinanceiraId;
        this.formaPagamentoId = formaPagamentoId;
        this.vendaId = vendaId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public int getMovimentacaoFinanceiraId() {
        return movimentacaoFinanceiraId;
    }

    public void setMovimentacaoFinanceiraId(int movimentacaoFinanceiraId) {
        this.movimentacaoFinanceiraId = movimentacaoFinanceiraId;
    }

    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(int formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "FinanceiroEntrada{" + "id=" + id + ", dataVencimento=" + dataVencimento + ", valor=" + valor + ", numParcela=" + numParcela + ", dataBaixa=" + dataBaixa + ", movimentacaoFinanceiraId=" + movimentacaoFinanceiraId + ", formaPagamentoId=" + formaPagamentoId + ", vendaId=" + vendaId + ", statusId=" + statusId + '}';
    }
    
}
