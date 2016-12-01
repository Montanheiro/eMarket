package model;

/**
 *
 * @author Bárbara
 */
public class FinanceiroEntrada {
    
    private int id;

    private String dataVencimento;
    private double valor;
    private String statusEntrada;
    private int numParcela;
    private String dataBaixa;
    
    private int movimentacaoFinanceiraId;
    private int formaPagamentoId;
    private int vendaId;

    public FinanceiroEntrada(String dataVencimento, double valor, String statusEntrada, int numParcela, String dataBaixa) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.statusEntrada = statusEntrada;
        this.numParcela = numParcela;
        this.dataBaixa = dataBaixa;
    }

    public FinanceiroEntrada(int id, String dataVencimento, double valor, String statusEntrada, int numParcela, String dataBaixa, int movimentacaoFinanceiraId, int formaPagamentoId, int vendaId) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.statusEntrada = statusEntrada;
        this.numParcela = numParcela;
        this.dataBaixa = dataBaixa;
        this.movimentacaoFinanceiraId = movimentacaoFinanceiraId;
        this.formaPagamentoId = formaPagamentoId;
        this.vendaId = vendaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatusEntrada() {
        return statusEntrada;
    }

    public void setStatusEntrada(String statusEntrada) {
        this.statusEntrada = statusEntrada;
    }

    public int getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }

    public String getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(String dataBaixa) {
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

    @Override
    public String toString() {
        return "FinanceiroEntrada{" + "id=" + id + ", dataVencimento=" + dataVencimento + ", valor=" + valor + ", statusEntrada=" + statusEntrada + ", numParcela=" + numParcela + ", dataBaixa=" + dataBaixa + ", movimentacaoFinanceiraId=" + movimentacaoFinanceiraId + ", formaPagamentoId=" + formaPagamentoId + ", vendaId=" + vendaId + '}';
    }
    
}
