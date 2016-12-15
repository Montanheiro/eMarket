package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class FinanceiroCaixa {
    
    private int id;

    private double valorInicial;
    private double valorFinal;
    private String dataAbertura;
    private String dataFechamento;
    private double sangria;
    private double suprimento;
    private String descricao;
    
    private int terminalVendaId;

    
    public FinanceiroCaixa() {
    }

    public FinanceiroCaixa(double valorInicial, double valorFinal, String dataAbertura, String dataFechamento, double suprimento, String descricao) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.suprimento = suprimento;
        this.descricao = descricao;
    }

    public FinanceiroCaixa(int id, double valorInicial, double valorFinal, String dataAbertura, String dataFechamento, double sangria, double suprimento, String descricao, int terminalVendaId) {
        this.id = id;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.sangria = sangria;
        this.suprimento = suprimento;
        this.descricao = descricao;
        this.terminalVendaId = terminalVendaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getSangria() {
        return sangria;
    }

    public void setSangria(double sangria) {
        this.sangria = sangria;
    }

    public double getSuprimento() {
        return suprimento;
    }

    public void setSuprimento(double suprimento) {
        this.suprimento = suprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTerminalVendaId() {
        return terminalVendaId;
    }

    public void setTerminalVendaId(int terminalVendaId) {
        this.terminalVendaId = terminalVendaId;
    }

    @Override
    public String toString() {
        return "FinanceiroCaixa{" + "id=" + id + ", valorInicial=" + valorInicial + ", valorFinal=" + valorFinal + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", sangria=" + sangria + ", suprimento=" + suprimento + ", descricao=" + descricao + ", terminalVendaId=" + terminalVendaId + '}';
    }
        
    
}
