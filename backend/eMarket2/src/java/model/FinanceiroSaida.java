package model;

/**
 *
 * @author Bárbara
 */
public class FinanceiroSaida {
        
    private int id;

    private String dataVencimento;
    private String dataBaixa;
    private String dataEmissao;
    private double valor;
    private String status;
        
    private int movimentacaoFinanceiraId;
    private int compraId;
    private int formaPagamentoId;

    public FinanceiroSaida(String dataVencimento, String dataBaixa, String dataEmissao, double valor, String status) {
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.dataEmissao = dataEmissao;
        this.valor = valor;
        this.status = status;
    }

    public FinanceiroSaida(int id, String dataVencimento, String dataBaixa, String dataEmissao, double valor, String status, int movimentacaoFinanceiraId, int compraId, int formaPagamentoId) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.dataEmissao = dataEmissao;
        this.valor = valor;
        this.status = status;
        this.movimentacaoFinanceiraId = movimentacaoFinanceiraId;
        this.compraId = compraId;
        this.formaPagamentoId = formaPagamentoId;
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

    public String getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(String dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMovimentacaoFinanceiraId() {
        return movimentacaoFinanceiraId;
    }

    public void setMovimentacaoFinanceiraId(int movimentacaoFinanceiraId) {
        this.movimentacaoFinanceiraId = movimentacaoFinanceiraId;
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
        return "FinanceiroSaida{" + "id=" + id + ", dataVencimento=" + dataVencimento + ", dataBaixa=" + dataBaixa + ", dataEmissao=" + dataEmissao + ", valor=" + valor + ", status=" + status + ", movimentacaoFinanceiraId=" + movimentacaoFinanceiraId + ", compraId=" + compraId + ", formaPagamentoId=" + formaPagamentoId + '}';
    }
    
    
}
